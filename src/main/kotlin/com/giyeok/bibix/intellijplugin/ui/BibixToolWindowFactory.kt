package com.giyeok.bibix.intellijplugin.ui

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.openapi.externalSystem.service.task.ui.AbstractExternalSystemToolWindowFactory
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings
import com.intellij.openapi.project.Project

class BibixToolWindowFactory : AbstractExternalSystemToolWindowFactory(SYSTEM_ID) {
  override fun getSettings(project: Project): AbstractExternalSystemSettings<*, *, *> {
    return BibixSettings.getInstance(project)
  }
}
