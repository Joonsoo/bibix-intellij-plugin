package com.giyeok.bibix.intellijplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.Logger

class SyncBuildFileAction : AnAction("Reload Project") {
  val LOG: Logger = Logger.getInstance(SyncBuildFileAction::class.java)

  override fun actionPerformed(e: AnActionEvent) {
    e.project?.let { project ->
      LOG.warn("sync: $project")
    }
  }
}
