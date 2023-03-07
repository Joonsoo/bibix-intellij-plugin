package com.giyeok.bibix.intellijplugin.settings

import com.intellij.openapi.externalSystem.service.settings.AbstractExternalProjectSettingsControl
import com.intellij.openapi.externalSystem.util.PaintAwarePanel

class BibixProjectSettingsControl(initialSettings: BibixProjectSettings) :
  AbstractExternalProjectSettingsControl<BibixProjectSettings>(initialSettings) {

  override fun validate(settings: BibixProjectSettings): Boolean {
    return true
  }

  override fun fillExtraControls(content: PaintAwarePanel, indentLevel: Int) {
    // TODO
  }

  override fun isExtraSettingModified(): Boolean {
    return false
  }

  override fun resetExtraSettings(isDefaultModuleCreation: Boolean) {
    // TODO
  }

  override fun applyExtraSettings(settings: BibixProjectSettings) {
    // TODO
  }
}
