package com.giyeok.bibix.intellijplugin.projectOpen

import com.intellij.ide.impl.runUnderModalProgressIfIsEdt
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor

class BibixProjectOpenProcessor: ProjectOpenProcessor() {
  override val name: String
    get() = "bibix"

  val impl = BibixOpenProjectProvider()

  override fun canOpenProject(file: VirtualFile): Boolean =
    impl.canOpenProject(file)

  override fun doOpenProject(
    projectFile: VirtualFile,
    projectToClose: Project?,
    forceOpenInNewFrame: Boolean
  ): Project? = runUnderModalProgressIfIsEdt {
    impl.openProject(projectFile, projectToClose, forceOpenInNewFrame)
  }

  override suspend fun openProjectAsync(
    virtualFile: VirtualFile,
    projectToClose: Project?,
    forceOpenInNewFrame: Boolean
  ): Project? =
    impl.openProject(virtualFile, projectToClose, forceOpenInNewFrame)

  override fun canImportProjectAfterwards(): Boolean = true

  override fun importProjectAfterwards(project: Project, file: VirtualFile) =
    impl.linkToExistingProject(file.path, project)
}
