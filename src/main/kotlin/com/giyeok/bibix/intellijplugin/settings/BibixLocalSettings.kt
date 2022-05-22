package com.giyeok.bibix.intellijplugin.settings

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemLocalSettings
import com.intellij.openapi.project.Project

class BibixLocalSettings(project: Project) :
  AbstractExternalSystemLocalSettings<BibixLocalSettings.MyState>(SYSTEM_ID, project) {
  companion object {
    fun getInstance(project: Project) =
      project.getService(BibixLocalSettings::class.java)
  }

  class MyState : State()
}
