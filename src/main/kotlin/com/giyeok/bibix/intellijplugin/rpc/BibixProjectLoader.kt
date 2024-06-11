package com.giyeok.bibix.intellijplugin.rpc

import com.giyeok.bibix.intellij.BibixIntellijProto
import com.giyeok.bibix.intellij.BibixIntellijServiceGrpc
import com.giyeok.bibix.intellij.loadProjectReq
import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.services.*
import com.giyeok.bibix.intellijplugin.system.BibixProjectResolverUtil
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.roots.DependencyScope
import io.grpc.ManagedChannel
import java.nio.file.Path
import kotlin.io.path.absolutePathString

class BibixProjectLoader(val projectRoot: Path, val scriptFileName: String) {
  private val projectAbsolutePath = projectRoot.absolutePathString()

  fun loadProjectStructure(channel: ManagedChannel): DataNode<ProjectData> {
    val stub = BibixIntellijServiceGrpc.newBlockingStub(channel)
    val projectInfo = stub.loadProject(loadProjectReq {
      this.projectRoot = projectAbsolutePath
      this.scriptName = scriptFileName
      // this.forceReload = true
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

      externalLib.nativeLibDirsList.forEach { loc ->
        libraryNode.createChild(
          BibixNativeLibLocsData.KEY,
          BibixNativeLibLocsData(BibixConstants.SYSTEM_ID, loc)
        )
      }

      externalLib.libraryId to libraryData
    }

    projectInfo.sdkInfo.ktjvmSdksList.forEach { ktjvmSdk ->
      projectNode.createChild(
        BibixSdkData.KEY,
        BibixKtJvmSdkData(
          BibixConstants.SYSTEM_ID,
          version = ktjvmSdk.version,
          sdkLibraryIds = ktjvmSdk.sdkLibraryIdsList.toList()
        )
      )
    }
    projectInfo.sdkInfo.scalaSdksList.forEach { scalaSdk ->
      projectNode.createChild(
        BibixSdkData.KEY,
        BibixScalaSdkData(
          BibixConstants.SYSTEM_ID,
          version = scalaSdk.version,
          langVersion = scalaSdk.scalaLanguageVersion,
          compilerClasspaths = scalaSdk.compilerClasspathsList.toList(),
          sdkLibraryIds = scalaSdk.sdkLibraryIdsList.toList()
        )
      )
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
          val sourceType = when (contentRoot.contentRootType) {
            "src" -> ExternalSystemSourceType.SOURCE
            "res" -> ExternalSystemSourceType.RESOURCE
            "excluded" -> ExternalSystemSourceType.EXCLUDED
            else -> ExternalSystemSourceType.SOURCE
          }
          contentRootData.storePath(sourceType, contentRoot.contentRootPath)
        }
        moduleNode.createChild(ProjectKeys.CONTENT_ROOT, contentRootData)
      }

      module.libraryDepsList.forEach { libraryDep ->
        val libraryData = projectLibrariesMap.getValue(libraryDep.libraryName)
        val libraryDepData =
          LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.PROJECT)
        libraryDepData.scope = when (libraryDep.dependencyType) {
          BibixIntellijProto.DependencyType.DEPENDENCY_UNSPECIFIED -> TODO()
          BibixIntellijProto.DependencyType.COMPILE_DEPENDENCY -> DependencyScope.COMPILE
          BibixIntellijProto.DependencyType.RUNTIME_DEPENDENCY -> DependencyScope.RUNTIME
          BibixIntellijProto.DependencyType.UNRECOGNIZED -> TODO()
        }
        // libraryDepData.isExported = true
        moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDepData)
      }

      module.usingSdksList.forEach { usingSdk ->
        when (usingSdk.sdkCase) {
          BibixIntellijProto.SdkVersion.SdkCase.JDK_VERSION ->
            moduleNode.createChild(
              BibixUsingSdkVersionData.KEY,
              BibixUsingJdkVersionData(BibixConstants.SYSTEM_ID, usingSdk.jdkVersion)
            )

          BibixIntellijProto.SdkVersion.SdkCase.KTJVM_SDK_VERSION ->
            moduleNode.createChild(
              BibixUsingSdkVersionData.KEY,
              BibixUsingKtJvmSdkVersionData(BibixConstants.SYSTEM_ID, usingSdk.ktjvmSdkVersion),
            )

          BibixIntellijProto.SdkVersion.SdkCase.SCALA_SDK_VERSION ->
            moduleNode.createChild(
              BibixUsingSdkVersionData.KEY,
              BibixUsingScalaSdkVersionData(BibixConstants.SYSTEM_ID, usingSdk.scalaSdkVersion)
            )

          BibixIntellijProto.SdkVersion.SdkCase.SDK_NOT_SET, null -> {
            // Shouldn't happen
          }
        }
      }

      module.moduleName to Pair(moduleData, moduleNode)
    }

    projectInfo.modulesList.forEach { module ->
      val (ownerModuleData, ownerModuleNode) = moduleDataMap.getValue(module.moduleName)

      module.moduleDepsList.forEach { moduleDep ->
        val moduleData = moduleDataMap.getValue(moduleDep.moduleName).first
        val moduleDepData = ModuleDependencyData(ownerModuleData, moduleData)
        moduleDepData.scope = when (moduleDep.dependencyType) {
          BibixIntellijProto.DependencyType.COMPILE_DEPENDENCY -> DependencyScope.COMPILE
          BibixIntellijProto.DependencyType.RUNTIME_DEPENDENCY -> DependencyScope.RUNTIME
          else -> TODO()
        }
        // moduleDepData.isExported = true
        ownerModuleNode.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDepData)
      }
    }

    return projectNode
  }
}
