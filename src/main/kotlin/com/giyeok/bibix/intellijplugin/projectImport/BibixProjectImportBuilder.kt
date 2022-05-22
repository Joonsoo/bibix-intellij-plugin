package com.giyeok.bibix.intellijplugin.projectImport

import com.giyeok.bibix.intellijplugin.BibixBundle
import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.ImportFromBibixControl
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.ProjectDataManager
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportBuilder
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.projectRoots.Sdk
import icons.BibixIcons
import java.io.File
import javax.swing.Icon

class BibixProjectImportBuilder : AbstractExternalProjectImportBuilder<ImportFromBibixControl>(
  ProjectDataManager.getInstance(),
  { ImportFromBibixControl() },
  BibixConstants.SYSTEM_ID
) {
  override fun getName(): String = BibixBundle.message("bibix.name")

  override fun getIcon(): Icon = BibixIcons.Bibix

//  override fun getList(): List<Any> = emptyList()
//
//  override fun isMarked(element: Any?): Boolean = true
//
//  override fun setOpenProjectSettingsAfter(on: Boolean) {}
//
//  override fun createProject(name: String?, path: String): Project? {
//    return setupCreatedProject(super.createProject(name, path))
//  }
//
//  override fun validate(currentProject: Project?, project: Project): Boolean {
//    return canLinkAndRefreshBibixProject(fileToImport, project)
//  }
//
//
//
//  override fun commit(
//    project: Project,
//    model: ModifiableModuleModel?,
//    modulesProvider: ModulesProvider?,
//    artifactModel: ModifiableArtifactModel?
//  ): List<Module> {
//    linkAndRefreshBibixProject(fileToImport, project)
//    return emptyList()
//  }

  override fun doPrepare(context: WizardContext) {
  }

  override fun beforeCommit(dataNode: DataNode<ProjectData>, project: Project) {
  }

  override fun getExternalProjectConfigToUse(file: File): File =
    if (file.isDirectory) file else file.parentFile

  override fun applyExtraSettings(context: WizardContext) {
  }

  override fun resolveProjectJdk(context: WizardContext): Sdk? {
    val javaSdkType = JavaSdk.getInstance()
    val jdkTable = ProjectJdkTable.getInstance()
    val mostRecentSdk = jdkTable.getSdksOfType(javaSdkType).stream()
      .max(javaSdkType.versionComparator()).orElse(null)
    if (mostRecentSdk != null) {
      return mostRecentSdk
    }
    return null
  }
}
