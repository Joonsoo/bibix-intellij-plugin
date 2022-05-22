package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.openapi.externalSystem.service.settings.AbstractImportFromExternalSystemControl
import com.intellij.openapi.externalSystem.util.ExternalSystemSettingsControl
import com.intellij.openapi.project.ProjectManager

class ImportFromBibixControl : AbstractImportFromExternalSystemControl<
  BibixProjectSettings, BibixSettingsListener, BibixSettings>(
  SYSTEM_ID,
  BibixSettings(ProjectManager.getInstance().defaultProject),
  getInitialProjectSettings(),
  true
) {

  companion object {
    fun getInitialProjectSettings(): BibixProjectSettings {
      val result = BibixProjectSettings()
      val bibixHome = "??"
      return result
    }
  }

  override fun onLinkedProjectPathChange(path: String) {
    // TODO
  }

  override fun createSystemSettingsControl(settings: BibixSettings): ExternalSystemSettingsControl<BibixSettings>? {
    // TODO
    return null
  }

  override fun createProjectSettingsControl(settings: BibixProjectSettings): ExternalSystemSettingsControl<BibixProjectSettings> {
    // TODO
    return BibixProjectSettingsControl()
  }
}
