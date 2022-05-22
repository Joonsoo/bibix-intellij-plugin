package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.util.messages.Topic

interface BibixSettingsListener : ExternalSystemSettingsListener<BibixProjectSettings> {
  companion object {
    val TOPIC = Topic.create("Bibix-specific settings", BibixSettingsListener::class.java)
  }
}
