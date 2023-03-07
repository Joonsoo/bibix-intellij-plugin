package com.giyeok.bibix.intellijplugin.projectImport

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.projectOpen.canOpenBibixProject
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportProvider
import com.intellij.openapi.vfs.VirtualFile

class BibixProjectImportProvider :
  AbstractExternalProjectImportProvider(BibixProjectImportBuilder(), SYSTEM_ID) {

  override fun canImportFromFile(file: VirtualFile): Boolean =
    canOpenBibixProject(file)
}
