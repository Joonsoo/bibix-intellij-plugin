package com.giyeok.bibix.intellijplugin.projectOpen

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor

class BibixProjectOpenProcessor: ProjectOpenProcessor() {
  override val name: String
    get() = "bibix"

  override fun canOpenProject(file: VirtualFile): Boolean {
    return canOpenBibixProject(file)
  }

  override fun doOpenProject(
    projectFile: VirtualFile,
    projectToClose: Project?,
    forceOpenInNewFrame: Boolean
  ): Project? {
    return openBibixProject(projectFile, projectToClose, forceOpenInNewFrame)
  }

  override fun canImportProjectAfterwards(): Boolean = true

  override fun importProjectAfterwards(project: Project, file: VirtualFile) {
    linkAndRefreshBibixProject(file.path, project)
  }
}
