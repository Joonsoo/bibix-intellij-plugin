package com.giyeok.bibix.intellijplugin.settings

import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.BibixSettingsListener.Companion.TOPIC
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.openapi.project.Project
import java.util.*

@State(name = "BibixSettings", storages = [Storage("bibix.xml")])
class BibixSettings(project: Project):
  AbstractExternalSystemSettings<
    BibixSettings,
    BibixProjectSettings,
    BibixSettingsListener>(TOPIC, project),
  PersistentStateComponent<BibixSettings.MyState> {
  companion object {
    fun getInstance(project: Project): BibixSettings =
      project.getService(BibixSettings::class.java)
  }

  override fun subscribe(
    listener: ExternalSystemSettingsListener<BibixProjectSettings>,
    parentDisposable: Disposable
  ) {
    doSubscribe(object: BibixSettingsListener {}, parentDisposable)
  }

  override fun copyExtraSettingsFrom(settings: BibixSettings) {
  }

  override fun loadState(state: MyState) {
    super.loadState(state)
  }

  override fun getState(): MyState? {
    val state = MyState()
    fillState(state)
    return state
  }

  override fun checkSettings(old: BibixProjectSettings, current: BibixProjectSettings) {
    // TODO
    publisher.onProjectsLoaded(listOf())
  }

  class MyState: State<BibixProjectSettings> {
    private val myProjectSettings = TreeSet<BibixProjectSettings>()

    override fun getLinkedExternalProjectsSettings(): MutableSet<BibixProjectSettings> {
      return myProjectSettings
    }

    override fun setLinkedExternalProjectsSettings(settings: MutableSet<BibixProjectSettings>?) {
      settings?.let { myProjectSettings.addAll(settings) }
    }
  }
}
