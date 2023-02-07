package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc
import com.giyeok.bibix.intellij.loadProjectReq
import com.giyeok.bibix.intellijplugin.services.BibixJavaSdkData
import com.giyeok.bibix.intellijplugin.services.BibixModuleSdkData
import com.giyeok.bibix.intellijplugin.system.BibixProjectResolverUtil
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.*
import io.grpc.ManagedChannel
import java.nio.file.Path
import kotlin.io.path.absolutePathString

class BibixProjectLoader(val projectRoot: Path, val scriptFileName: String) {
  fun loadProjectStructure(channel: ManagedChannel): DataNode<ProjectData> {
    val stub = BibixIntellijServiceGrpc.newBlockingStub(channel)
    val projectAbsolutePath = projectRoot.absolutePathString()
    val projectInfo = stub.loadProject(loadProjectReq {
      this.projectRoot = projectAbsolutePath
      this.scriptName = scriptFileName
    })

    val projectData = ProjectData(
      BibixConstants.SYSTEM_ID,
      projectInfo.projectName,
      projectAbsolutePath,
      projectAbsolutePath
    )
    val projectNode = DataNode(ProjectKeys.PROJECT, projectData, null)

    val moduleTypeId = BibixProjectResolverUtil.getDefaultModuleTypeId()

    val projectLibrariesMap = projectInfo.externalLibrariesList.associate { externalLib ->
      val libraryData = LibraryData(BibixConstants.SYSTEM_ID, externalLib.libraryId)

      externalLib.classpathsList.forEach { cp ->
        libraryData.addPath(LibraryPathType.BINARY, cp)
      }
      externalLib.sourcesList.forEach { src ->
        libraryData.addPath(LibraryPathType.SOURCE, src)
      }

      val libraryNode = projectNode.createChild(ProjectKeys.LIBRARY, libraryData)

      externalLib.libraryId to libraryData
    }

    val moduleDataMap = projectInfo.modulesList.associate { module ->
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

      module.libraryDepsList.forEach { libraryId ->
        val libraryData = projectLibrariesMap.getValue(libraryId)
        val libraryDepData =
          LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.PROJECT)
        moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDepData)
      }

      if (module.sdkVersion.isNotEmpty()) {
        moduleNode.createChild(
          BibixModuleSdkData.KEY,
          BibixJavaSdkData(BibixConstants.SYSTEM_ID, module.sdkVersion)
        )
      }

      module.moduleName to Pair(moduleData, moduleNode)
    }

    projectInfo.modulesList.forEach { module ->
      val (ownerModuleData, ownerModuleNode) = moduleDataMap.getValue(module.moduleName)

      module.moduleDepsList.forEach { moduleDep ->
        val moduleData = moduleDataMap.getValue(moduleDep).first
        val moduleDepData = ModuleDependencyData(ownerModuleData, moduleData)
        moduleDepData.isExported = true
        ownerModuleNode.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDepData)
      }
    }

    return projectNode
  }
}
