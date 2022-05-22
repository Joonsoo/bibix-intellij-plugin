package com.giyeok.bibix.intellijplugin.projectImport

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportProvider
import com.intellij.openapi.vfs.VirtualFile

class BibixProjectImportProvider :
  AbstractExternalProjectImportProvider(BibixProjectImportBuilder(), BibixConstants.SYSTEM_ID) {
  override fun createSteps(context: WizardContext): Array<ModuleWizardStep> {
    return ModuleWizardStep.EMPTY_ARRAY
  }

  override fun getPathToBeImported(file: VirtualFile): String =
    getDefaultPath(file)

  override fun canImportFromFile(file: VirtualFile): Boolean =
    canOpenBibixProject(file)

  override fun getFileSample(): String {
    return "TODO"
  }
}
