package com.giyeok.bibix.intellijplugin.projectOpen

import com.intellij.ide.impl.ProjectUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor
import java.nio.file.Path

class BibixProjectOpenProcessor : ProjectOpenProcessor() {
  override val name: String = "bibix"

  override fun canOpenProject(file: VirtualFile): Boolean {
    return BibixOpenProjectProvider().canOpenProject(file)
  }

  override suspend fun openProjectAsync(
    virtualFile: VirtualFile,
    projectToClose: Project?,
    forceOpenInNewFrame: Boolean
  ): Project? =
    BibixOpenProjectProvider().openProject(virtualFile, projectToClose, forceOpenInNewFrame)

  fun getProjectDirectory(file: VirtualFile): VirtualFile {
    return if (file.isDirectory) file else file.parent
  }

  fun focusOnOpenedSameProject(projectDirectory: Path): Boolean {
    for (project in ProjectManager.getInstance().openProjects) {
      if (ProjectUtil.isSameProject(projectDirectory, project)) {
        ProjectUtil.focusProjectWindow(project, false)
        return true
      }
    }
    return false
  }

  // doOpenProject가 null을 반환하면 openProjectAsync가 도나? 아니면 openProjectAsync를 해보고 실패하면 여기로 오나?
  override fun doOpenProject(
    virtualFile: VirtualFile,
    projectToClose: Project?,
    forceOpenInNewFrame: Boolean
  ): Project? = null

  override fun canImportProjectAfterwards(): Boolean = true

  override fun importProjectAfterwards(project: Project, file: VirtualFile) {
    BibixOpenProjectProvider().linkToExistingProject(file.path, project)
  }
}
