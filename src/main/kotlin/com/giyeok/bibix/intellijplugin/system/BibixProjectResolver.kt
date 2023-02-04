package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver

class BibixProjectResolver : ExternalSystemProjectResolver<BibixExecutionSettings> {
  private val LOG: Logger = Logger.getInstance(BibixProjectResolver::class.java)

  override fun resolveProjectInfo(
    id: ExternalSystemTaskId,
    projectPath: String,
    isPreviewMode: Boolean,
    settings: BibixExecutionSettings?,
    listener: ExternalSystemTaskNotificationListener
  ): DataNode<ProjectData> {
    LOG.info("resolveProjectInfo called")
    return settings!!.projectDataNode
  }

  override fun cancelTask(
    taskId: ExternalSystemTaskId,
    listener: ExternalSystemTaskNotificationListener
  ): Boolean {
    return true
  }
}
