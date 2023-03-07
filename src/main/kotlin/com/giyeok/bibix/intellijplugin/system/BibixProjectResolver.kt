package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.rpc.BibixProjectLoader
import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import io.grpc.ManagedChannelBuilder
import kotlin.io.path.Path

class BibixProjectResolver : ExternalSystemProjectResolver<BibixExecutionSettings> {
  private val LOG: Logger = Logger.getInstance(BibixProjectResolver::class.java)

  private val channel = ManagedChannelBuilder.forAddress("localhost", 8088).usePlaintext().build()

  override fun resolveProjectInfo(
    id: ExternalSystemTaskId,
    projectPath: String,
    isPreviewMode: Boolean,
    settings: BibixExecutionSettings?,
    listener: ExternalSystemTaskNotificationListener
  ): DataNode<ProjectData> {
    LOG.warn("resolveProjectInfo called")
    listener.onStart(id, "Starting to resolve project at $projectPath...")
    listener.onEnd(id)
    return doResolveProjectInfo(projectPath)
  }

  fun doResolveProjectInfo(projectPath: String): DataNode<ProjectData> {
    val loader = BibixProjectLoader(Path(projectPath), "")
    return loader.loadProjectStructure(channel)
  }

  override fun cancelTask(
    taskId: ExternalSystemTaskId,
    listener: ExternalSystemTaskNotificationListener
  ): Boolean {
    return true
  }
}
