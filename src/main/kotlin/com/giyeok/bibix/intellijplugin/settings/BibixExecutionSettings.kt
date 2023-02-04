package com.giyeok.bibix.intellijplugin.settings

import com.giyeok.bibix.daemon.BibixDaemonApiProto
import com.giyeok.bibix.daemon.BibixDaemonApiProto.IntellijProjectStructure
import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.BibixProjectLoader
import com.giyeok.bibix.intellijplugin.services.BibixJavaSdkData
import com.giyeok.bibix.intellijplugin.services.BibixModuleSdkData
import com.giyeok.bibix.intellijplugin.services.BibixScalaSdkData
import com.giyeok.bibix.intellijplugin.system.BibixProjectResolverUtil
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.externalSystem.model.settings.ExternalSystemExecutionSettings
import kotlin.io.path.Path

class BibixExecutionSettings(
  val projectDataNode: DataNode<ProjectData>
) : ExternalSystemExecutionSettings() {
  companion object {
    fun convertProject(
      projectPath: String,
      projectStructure: IntellijProjectStructure
    ): DataNode<ProjectData> {
      val loader = BibixProjectLoader(Path(projectPath), "build.bbx")
      return loader.loadProjectStructure()

//      val projectName = projectStructure.project.name
//      val projectData =
//        ProjectData(
//          BibixConstants.SYSTEM_ID,
//          projectName,
//          projectPath,
//          projectStructure.project.path
//        )
//      val projectDataNode = DataNode(ProjectKeys.PROJECT, projectData, null)
//
//      val moduleTypeId = BibixProjectResolverUtil.getDefaultModuleTypeId()
//
//      val moduleNodeByName = mutableMapOf<String, DataNode<ModuleData>>()
//
//      if (projectStructure.project.jdkVersion.isNotEmpty()) {
//        projectDataNode.createChild(
//          BibixModuleSdkData.KEY,
//          BibixJavaSdkData(BibixConstants.SYSTEM_ID, projectStructure.project.jdkVersion)
//        )
//      }
//
//      projectStructure.project.modulesList.forEach { module ->
//        val moduleData = ModuleData(
//          module.name,
//          BibixConstants.SYSTEM_ID,
//          moduleTypeId,
//          module.name,
//          "$projectPath/.idea",
//          projectPath
//        )
//        if (module.objectPath.isNotEmpty()) {
//          moduleData.isInheritProjectCompileOutputPath = false
//          moduleData.setCompileOutputPath(
//            ExternalSystemSourceType.SOURCE,
//            module.objectPath + "-build"
//          )
//        }
//        val moduleNode = projectDataNode.createChild(ProjectKeys.MODULE, moduleData)
//
//        if (module.jdkVersion.isNotEmpty()) {
//          moduleNode.createChild(
//            BibixModuleSdkData.KEY,
//            BibixJavaSdkData(BibixConstants.SYSTEM_ID, module.jdkVersion)
//          )
//        }
//
//        module.contentRootsList.forEach { contentRoot ->
//          val contentRootData = ContentRootData(BibixConstants.SYSTEM_ID, contentRoot.path)
//          contentRootData.storePath(ExternalSystemSourceType.SOURCE, contentRoot.path)
//          moduleNode.createChild(ProjectKeys.CONTENT_ROOT, contentRootData)
//        }
//
//        moduleNodeByName[module.name] = moduleNode
//      }
//
//      val projectLibraryDataMap = projectStructure.project.librariesList.associate { library ->
//        val libraryData = LibraryData(BibixConstants.SYSTEM_ID, library.libraryName)
//        library.classpathList.forEach {
//          libraryData.addPath(LibraryPathType.BINARY, it)
//        }
//        library.sourceList.forEach {
//          libraryData.addPath(LibraryPathType.SOURCE, it)
//        }
//        val libraryNode = projectDataNode.createChild(ProjectKeys.LIBRARY, libraryData)
//        when (library.libraryCase) {
//          BibixDaemonApiProto.IntellijLibraryNode.LibraryCase.SCALA_SDK_LIBRARY ->
//            libraryNode.createChild(
//              BibixModuleSdkData.KEY,
//              BibixScalaSdkData(
//                BibixConstants.SYSTEM_ID,
//                library.libraryName,
//                library.scalaSdkLibrary.scalaVersion
//              )
//            )
//          else -> {
//            // do nothing
//          }
//        }
//        library.libraryName to libraryData
//      }
//
//      projectStructure.project.modulesList.forEach { module ->
//        val moduleNode = moduleNodeByName.getValue(module.name)
//
//        module.dependenciesList.forEach { dep ->
//          when (dep.dependencyCase) {
//            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.LIBRARY_NAME -> {
//              val libraryData = projectLibraryDataMap.getValue(dep.libraryName)
//              val libraryDependencyData =
//                LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.PROJECT)
//              moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDependencyData)
//            }
//            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.MODULE_NAME -> {
//              val dependingModuleData = moduleNodeByName[dep.moduleName]!!.data
//              val moduleDepData = ModuleDependencyData(moduleNode.data, dependingModuleData)
//              moduleDepData.isExported = true
//              moduleNode.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDepData)
//            }
//            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.DEPENDENCY_NOT_SET, null -> {
//              // ??
//            }
//          }
//        }
//      }
    }
  }
}
