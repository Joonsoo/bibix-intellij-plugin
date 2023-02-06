package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc
import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc.BibixIntellijServiceBlockingStub
import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc.BibixIntellijServiceFutureStub
import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc.BibixIntellijServiceStub
import com.giyeok.bibix.intellij.loadProjectReq
import com.giyeok.bibix.intellijplugin.system.BibixManager
import com.giyeok.bibix.intellijplugin.system.BibixProjectResolverUtil
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ContentRootData
import com.intellij.openapi.externalSystem.model.project.ExternalSystemSourceType
import com.intellij.openapi.externalSystem.model.project.ModuleData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.jetbrains.jps.ProjectPaths
import java.nio.file.Path
import kotlin.io.path.absolutePathString

class BibixProjectLoader(val projectRoot: Path, val scriptName: String) {
  fun loadProjectStructure(channel: ManagedChannel): DataNode<ProjectData> {
    val stub = BibixIntellijServiceGrpc.newBlockingStub(channel)
    val projectAbsolutePath = projectRoot.absolutePathString()
    val projectInfo = stub.loadProject(loadProjectReq {
      this.projectRoot = projectAbsolutePath
      this.scriptName = scriptName
    })

    val projectData = ProjectData(
      BibixConstants.SYSTEM_ID,
      projectInfo.projectName,
      projectAbsolutePath,
      projectAbsolutePath
    )
    val projectNode = DataNode(ProjectKeys.PROJECT, projectData, null)

    val moduleTypeId = BibixProjectResolverUtil.getDefaultModuleTypeId()

    projectInfo.modulesList.forEach { module ->
      val moduleData = ModuleData(
        module.moduleName,
        BibixConstants.SYSTEM_ID,
        moduleTypeId,
        module.moduleName,
        "$projectAbsolutePath/.idea",
        projectAbsolutePath,
      )
      val moduleNode = projectNode.createChild(ProjectKeys.MODULE, moduleData)
      module.contentRootsList.forEach { contentRoot ->
        val contentRootData = ContentRootData(BibixConstants.SYSTEM_ID, contentRoot.contentRootPath)
        // TODO source 이외의 다른 타입 지원
        contentRootData.storePath(ExternalSystemSourceType.SOURCE, contentRoot.contentRootPath)
        moduleNode.createChild(ProjectKeys.CONTENT_ROOT, contentRootData)
      }
    }

    return projectNode
  }
}
