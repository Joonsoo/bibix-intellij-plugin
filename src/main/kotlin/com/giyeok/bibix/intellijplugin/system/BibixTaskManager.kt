package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.task.ExternalSystemTaskManager

class BibixTaskManager : ExternalSystemTaskManager<BibixExecutionSettings> {
  private val LOG: Logger = Logger.getInstance(BibixTaskManager::class.java)

  override fun executeTasks(
    id: ExternalSystemTaskId,
    taskNames: MutableList<String>,
    projectPath: String,
    settings: BibixExecutionSettings?,
    jvmParametersSetup: String?,
    listener: ExternalSystemTaskNotificationListener
  ) {
    // TODO
    LOG.error("executeTasks $id $taskNames $projectPath")
  }

  override fun cancelTask(
    id: ExternalSystemTaskId,
    listener: ExternalSystemTaskNotificationListener
  ): Boolean {
    return false
  }
}
