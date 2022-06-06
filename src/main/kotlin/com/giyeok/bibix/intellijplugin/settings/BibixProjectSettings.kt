package com.giyeok.bibix.intellijplugin.settings

import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings

class BibixProjectSettings : ExternalProjectSettings() {
  override fun clone(): ExternalProjectSettings {
    return BibixProjectSettings()
  }
}
