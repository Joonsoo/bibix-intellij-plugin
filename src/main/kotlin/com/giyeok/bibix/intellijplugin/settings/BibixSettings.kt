package com.giyeok.bibix.intellijplugin.settings

import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.BibixSettingsListener.Companion.TOPIC
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.openapi.project.Project

@State(name = "BibixSettings", storages = [Storage("bibix.xml")])
class BibixSettings(project: Project) :
  AbstractExternalSystemSettings<BibixSettings, BibixProjectSettings, BibixSettingsListener>(
    TOPIC,
    project
  ) {
  companion object {
    fun getInstance(project: Project): BibixSettings =
      project.getService(BibixSettings::class.java)
  }

  override fun subscribe(listener: ExternalSystemSettingsListener<BibixProjectSettings>) {
  }

  override fun copyExtraSettingsFrom(settings: BibixSettings) {
  }

  override fun checkSettings(old: BibixProjectSettings, current: BibixProjectSettings) {
    // TODO
    publisher.onProjectsLoaded(listOf())
  }
}
