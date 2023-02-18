package com.giyeok.bibix.intellijplugin

import com.giyeok.bibix.intellij.BibixIntellijProto
import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc
import com.giyeok.bibix.intellij.loadProjectReq
import com.giyeok.bibix.intellijplugin.services.*
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

      projectNode.createChild(ProjectKeys.LIBRARY, libraryData)

      externalLib.libraryId to libraryData
    }

    val ktjvmSdks = projectInfo.sdks.ktjvmSdksList.associate { ktjvmSdk ->
      val sdkData = KtJvmSdkData(
        version = ktjvmSdk.version,
        sdkLibraryIds = ktjvmSdk.sdkLibraryIdsList.toList()
      )
      projectNode.createChild(
        BibixSdkData.KEY,
        BibixKtJvmSdkData(BibixConstants.SYSTEM_ID, sdkData)
      )
      sdkData.version to sdkData
    }
    val scalaSdks = projectInfo.sdks.scalaSdksList.associate { scalaSdk ->
      val sdkData = ScalaSdkData(
        version = scalaSdk.version,
        langVersion = scalaSdk.scalaLanguageVersion,
        compilerClasspaths = scalaSdk.compilerClasspathsList.toList(),
        sdkLibraryIds = scalaSdk.sdkLibraryIdsList.toList()
      )
      projectNode.createChild(
        BibixSdkData.KEY,
        BibixScalaSdkData(BibixConstants.SYSTEM_ID, sdkData)
      )
      sdkData.version to sdkData
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

      if (module.contentRootsCount > 0) {
        val contentRootData = ContentRootData(BibixConstants.SYSTEM_ID, module.moduleRootPath)
        module.contentRootsList.forEach { contentRoot ->
          // TODO source 이외의 다른 타입 지원
          val sourceType = when (contentRoot.contentRootType) {
            "src" -> ExternalSystemSourceType.SOURCE
            "res" -> ExternalSystemSourceType.RESOURCE
            else -> ExternalSystemSourceType.SOURCE
          }
          contentRootData.storePath(sourceType, contentRoot.contentRootPath)
        }
        moduleNode.createChild(ProjectKeys.CONTENT_ROOT, contentRootData)
      }

      module.libraryDepsList.forEach { libraryId ->
        val libraryData = projectLibrariesMap.getValue(libraryId)
        val libraryDepData =
          LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.PROJECT)
        libraryDepData.isExported = true
        moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDepData)
      }

      module.moduleSdksList.forEach { moduleSdk ->
        when (moduleSdk.sdkCase) {
          BibixIntellijProto.ModuleSdk.SdkCase.JDK_VERSION ->
            moduleNode.createChild(
              BibixModuleSdkData.KEY,
              BibixModuleJdkData(BibixConstants.SYSTEM_ID, moduleSdk.jdkVersion)
            )

          BibixIntellijProto.ModuleSdk.SdkCase.KTJVM_SDK_VERSION ->
            moduleNode.createChild(
              BibixModuleSdkData.KEY,
              BibixModuleKtJvmSdkData(
                BibixConstants.SYSTEM_ID,
                moduleSdk.ktjvmSdkVersion,
                ktjvmSdks.getValue(moduleSdk.ktjvmSdkVersion)
              ),
            )

          BibixIntellijProto.ModuleSdk.SdkCase.SCALA_SDK_VERSION ->
            moduleNode.createChild(
              BibixModuleSdkData.KEY,
              BibixModuleScalaSdkData(
                BibixConstants.SYSTEM_ID,
                moduleSdk.scalaSdkVersion,
                scalaSdks.getValue(moduleSdk.scalaSdkVersion)
              )
            )

          BibixIntellijProto.ModuleSdk.SdkCase.SDK_NOT_SET -> {
            // Shouldn't happen
          }
        }
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
