package com.giyeok.bibix.intellijplugin.settings

import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings

class BibixProjectSettings(
  val intellijDaemonAddress: String? = null,
  val autoDownloadIntellijDaemon: Boolean? = null,
) : ExternalProjectSettings() {
  override fun clone(): ExternalProjectSettings {
    return BibixProjectSettings()
  }
}
