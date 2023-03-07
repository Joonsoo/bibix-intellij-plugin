package com.giyeok.bibix.intellijplugin.projectImport

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettingsControl
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettingsControl
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.service.settings.AbstractImportFromExternalSystemControl
import com.intellij.openapi.externalSystem.util.ExternalSystemSettingsControl
import com.intellij.openapi.project.ProjectManager

class ImportFromBibixControl :
  AbstractImportFromExternalSystemControl<BibixProjectSettings, BibixSettingsListener, BibixSettings>(
    SYSTEM_ID,
    BibixSettings(ProjectManager.getInstance().defaultProject),
    getInitialProjectSettings(),
    true
  ) {
  companion object {
    fun getInitialProjectSettings(): BibixProjectSettings {
      return BibixProjectSettings()
    }
  }

  val LOG = Logger.getInstance(ImportFromBibixControl::class.java)

  override fun onLinkedProjectPathChange(path: String) {
    LOG.warn("onLinkedProjectPathChange $path")
  }

  override fun createProjectSettingsControl(settings: BibixProjectSettings): ExternalSystemSettingsControl<BibixProjectSettings> =
    BibixProjectSettingsControl(settings)

  override fun createSystemSettingsControl(settings: BibixSettings): ExternalSystemSettingsControl<BibixSettings> =
    BibixSettingsControl(settings)
}
