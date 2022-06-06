package com.giyeok.bibix.intellijplugin.action

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.externalSystem.action.ExternalSystemAction

class ImportFromBuildFileAction : ExternalSystemAction() {
  override fun isEnabled(e: AnActionEvent): Boolean {
    return true
  }

  override fun actionPerformed(e: AnActionEvent) {
    // TODO
  }
}
