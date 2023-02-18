package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.BibixProjectLoader
import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.giyeok.bibix.intellijplugin.settings.BibixLocalSettings
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.execution.configurations.SimpleJavaParameters
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.ExternalSystemAutoImportAware
import com.intellij.openapi.externalSystem.ExternalSystemManager
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.intellij.openapi.externalSystem.task.ExternalSystemTaskManager
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.util.Pair
import com.intellij.util.Function
import io.grpc.ManagedChannelBuilder
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder
import kotlin.io.path.Path

open class XX

class BibixManager : XX(),
  ExternalSystemAutoImportAware,
  StartupActivity,
//  ExternalSystemConfigurableAware,
  ExternalSystemManager<
    BibixProjectSettings,
    BibixSettingsListener,
    BibixSettings,
    BibixLocalSettings,
    BibixExecutionSettings> {
  val LOG: Logger = Logger.getInstance(BibixManager::class.java)

  override fun getSystemId(): ProjectSystemId = BibixConstants.SYSTEM_ID

  override fun getSettingsProvider(): Function<Project, BibixSettings> = Function { project ->
    BibixSettings.getInstance(project)
  }

  override fun getLocalSettingsProvider(): Function<Project, BibixLocalSettings> =
    Function { project ->
      BibixLocalSettings.getInstance(project)
    }

  val channel = NettyChannelBuilder.forAddress("localhost", 8088).usePlaintext().build()

  override fun getExecutionSettingsProvider(): Function<Pair<Project, String>, BibixExecutionSettings> =
    Function { pair: Pair<Project, String> ->
      val project = pair.first
      val projectPath = pair.second
      val settings = BibixSettings.getInstance(project)
      val projectLevelSettings = settings.getLinkedProjectSettings(projectPath)
      val rootProjectPath =
        if (projectLevelSettings != null) projectLevelSettings.externalProjectPath else projectPath
//
////      val channel = ManagedChannelBuilder.forAddress("localhost", 61617)
////        .usePlaintext().build()
//      val channel = NettyChannelBuilder.forAddress("localhost", 61617).usePlaintext().build()
//
//      val bibixClient = BibixDaemonApiGrpcKt.BibixDaemonApiCoroutineStub(channel)
//
//      val projectStructure = try {
//        runBlocking {
//          bibixClient.getIntellijProjectStructure(getIntellijProjectStructureReq { })
//        }
//      } finally {
//        channel.shutdown()
//      }
//

      val loader = BibixProjectLoader(Path(rootProjectPath), "")
      val projectNode = loader.loadProjectStructure(channel)
      BibixExecutionSettings(projectNode)
    }

  override fun enhanceRemoteProcessing(parameters: SimpleJavaParameters) {
    // TODO("Not yet implemented")
  }

  override fun getProjectResolverClass(): Class<out ExternalSystemProjectResolver<BibixExecutionSettings>> =
    BibixProjectResolver::class.java

  override fun getTaskManagerClass(): Class<out ExternalSystemTaskManager<BibixExecutionSettings>> =
    BibixTaskManager::class.java

  override fun getExternalProjectDescriptor(): FileChooserDescriptor =
    FileChooserDescriptorFactory.createSingleFileDescriptor()

  override fun getAffectedExternalProjectPath(
    changedFileOrDirPath: String,
    project: Project
  ): String? {
    LOG.warn("getAffectedExternalProjectPath $changedFileOrDirPath")
    return changedFileOrDirPath
  }

  override fun runActivity(project: Project) {
    LOG.warn("runActivity")
  }
}
