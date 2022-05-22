package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.intellij.openapi.externalSystem.util.ExternalSystemSettingsControl
import com.intellij.openapi.externalSystem.util.PaintAwarePanel

class BibixProjectSettingsControl : ExternalSystemSettingsControl<BibixProjectSettings> {
  override fun fillUi(canvas: PaintAwarePanel, indentLevel: Int) {
    // TODO
  }

  override fun reset() {
    // TODO
  }

  override fun isModified(): Boolean {
    return false
  }

  override fun disposeUIResources() {
    // TODO
  }

  override fun showUi(show: Boolean) {
    // TODO
  }

  override fun validate(settings: BibixProjectSettings): Boolean {
    return true
  }

  override fun apply(settings: BibixProjectSettings) {
    // TODO
  }

}
