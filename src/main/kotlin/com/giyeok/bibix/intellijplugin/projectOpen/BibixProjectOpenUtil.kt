package com.giyeok.bibix.intellijplugin.projectOpen

import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.openapi.externalSystem.util.ExternalSystemBundle
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.io.systemIndependentPath
import kotlinx.coroutines.runBlocking
import java.nio.file.Path

fun canOpenBibixProject(file: VirtualFile): Boolean =
  BibixOpenProjectProvider().canOpenProject(file)

fun openBibixProject(
  projectFile: VirtualFile,
  projectToClose: Project?,
  forceOpenInNewFrame: Boolean
): Project? = runBlocking {
  BibixOpenProjectProvider().openProject(projectFile, projectToClose, forceOpenInNewFrame)
}

fun canLinkAndRefreshBibixProject(
  projectFilePath: String,
  project: Project,
  showValidationDialog: Boolean = true
): Boolean {
  val validationInfo = validateBibixProject(projectFilePath, project) ?: return true
  if (showValidationDialog) {
    val title = ExternalSystemBundle.message("error.project.import.error.title")
    when (validationInfo.warning) {
      true -> Messages.showWarningDialog(project, validationInfo.message, title)
      else -> Messages.showErrorDialog(project, validationInfo.message, title)
    }
  }
  return false
}

fun linkAndRefreshBibixProject(projectFilePath: String, project: Project) {
  BibixOpenProjectProvider().linkToExistingProject(projectFilePath, project)
}

fun createLinkSettings(projectDirectory: Path, project: Project): BibixProjectSettings {
  val bibixSettings = BibixSettings.getInstance(project)
  bibixSettings.setupBibixSettings()
  val bibixProjectSettings = BibixProjectSettings()
  bibixProjectSettings.setupBibixProjectSettings(project, projectDirectory)

  setupBibixJvm(project, bibixProjectSettings)
  return bibixProjectSettings
}

fun setupBibixJvm(
  project: Project,
  projectSettings: BibixProjectSettings,
) {
  // TODO
}

fun updateBibixJvm(project: Project, externalProjectPath: String) {
  val settings = BibixSettings.getInstance(project)
  val projectSettings = settings.getLinkedProjectSettings(externalProjectPath) ?: return
  // TODO
}

fun BibixSettings.setupBibixSettings() {
}

fun BibixProjectSettings.setupBibixProjectSettings(project: Project, projectDirectory: Path) {
  externalProjectPath = projectDirectory.systemIndependentPath
  isUseQualifiedModuleNames = true
}

private fun validateBibixProject(projectFilePath: String, project: Project): ValidationInfo? {
  return null
}
