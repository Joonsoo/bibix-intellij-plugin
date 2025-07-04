package com.giyeok.bibix.intellijplugin.projectOpen

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.giyeok.bibix.intellijplugin.util.validateJavaHome
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.externalSystem.importing.AbstractOpenProjectProvider
import com.intellij.openapi.externalSystem.importing.ImportSpecBuilder
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.internal.InternalExternalProjectInfo
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.execution.ProgressExecutionMode
import com.intellij.openapi.externalSystem.service.project.ExternalProjectRefreshCallback
import com.intellij.openapi.externalSystem.service.project.ProjectDataManager
import com.intellij.openapi.externalSystem.service.project.manage.ExternalProjectsManagerImpl
import com.intellij.openapi.externalSystem.service.ui.ExternalProjectDataSelectorDialog
import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.util.registry.Registry
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.resolveFromRootOrRelative

class BibixOpenProjectProvider : AbstractOpenProjectProvider() {
  override val systemId: ProjectSystemId = BibixConstants.SYSTEM_ID

  override fun isProjectFile(file: VirtualFile): Boolean {
    return !file.isDirectory && file.name == "build.bbx"
  }

  override fun canOpenProject(file: VirtualFile): Boolean {
    return isProjectFile(file) ||
      (file.isDirectory && file.resolveFromRootOrRelative("build.bbx")?.exists() == true)
  }

  override fun linkToExistingProject(projectFile: VirtualFile, project: Project) {
    val bibixProjectSettings = createLinkSettings(projectFile.toNioPath(), project)

    attachBibixProjectAndRefresh(bibixProjectSettings, project)

    validateJavaHome(project, projectFile.toNioPath())
  }

  private fun attachBibixProjectAndRefresh(settings: ExternalProjectSettings, project: Project) {
    val externalProjectPath = settings.externalProjectPath
    ExternalSystemApiUtil.getSettings(project, BibixConstants.SYSTEM_ID).linkProject(settings)
    if (Registry.`is`("external.system.auto.import.disabled")) return

    ExternalSystemUtil.refreshProject(
      externalProjectPath,
      ImportSpecBuilder(project, BibixConstants.SYSTEM_ID)
        .usePreviewMode()
        .use(ProgressExecutionMode.MODAL_SYNC)
    )

    ExternalProjectsManagerImpl.getInstance(project).runWhenInitialized {
      ExternalSystemUtil.refreshProject(
        externalProjectPath,
        ImportSpecBuilder(project, BibixConstants.SYSTEM_ID).callback(
          createFinalImportCallback(project, externalProjectPath)
        )
      )
    }
  }

  private fun createFinalImportCallback(
    project: Project,
    externalProjectPath: String
  ): ExternalProjectRefreshCallback {
    return object : ExternalProjectRefreshCallback {
      override fun onSuccess(externalProject: DataNode<ProjectData>?) {
        if (externalProject == null) return
        selectDataToImport(project, externalProjectPath, externalProject)
        importData(project, externalProject)
        updateBibixJvm(project, externalProjectPath)
      }
    }
  }

  private fun selectDataToImport(
    project: Project,
    externalProjectPath: String,
    externalProject: DataNode<ProjectData>
  ) {
    val settings = BibixSettings.getInstance(project)
    val showSelectiveImportDialog = settings.showSelectiveImportDialogOnInitialImport()
    val application = ApplicationManager.getApplication()
    if (showSelectiveImportDialog && !application.isHeadlessEnvironment) {
      application.invokeAndWait {
        val projectInfo =
          InternalExternalProjectInfo(
            BibixConstants.SYSTEM_ID,
            externalProjectPath,
            externalProject
          )
        val dialog = ExternalProjectDataSelectorDialog(project, projectInfo)
        if (dialog.hasMultipleDataToSelect()) {
          dialog.showAndGet()
        } else {
          Disposer.dispose(dialog.disposable)
        }
      }
    }
  }

  private fun importData(project: Project, externalProject: DataNode<ProjectData>) {
    ProjectDataManager.getInstance().importData(externalProject, project, false)
  }
}
