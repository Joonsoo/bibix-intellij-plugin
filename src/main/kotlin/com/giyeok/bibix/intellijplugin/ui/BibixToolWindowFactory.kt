package com.giyeok.bibix.intellijplugin.ui

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.openapi.externalSystem.service.task.ui.AbstractExternalSystemToolWindowFactory
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings
import com.intellij.openapi.project.Project

class BibixToolWindowFactory : AbstractExternalSystemToolWindowFactory(SYSTEM_ID) {
  override fun shouldBeAvailable(project: Project): Boolean {
    // TODO 어딘가에서 이미 import된 project를 열 때는 project.
    return true
  }

  override fun getSettings(project: Project): AbstractExternalSystemSettings<*, *, *> {
    return BibixSettings.getInstance(project)
  }
}
