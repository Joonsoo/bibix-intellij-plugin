package com.giyeok.bibix.intellijplugin.settings

import com.intellij.openapi.externalSystem.util.ExternalSystemSettingsControl
import com.intellij.openapi.externalSystem.util.PaintAwarePanel

class BibixSettingsControl(settings: BibixSettings) : ExternalSystemSettingsControl<BibixSettings> {
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

  override fun validate(settings: BibixSettings): Boolean {
    return true
  }

  override fun apply(settings: BibixSettings) {
    // TODO
  }
}