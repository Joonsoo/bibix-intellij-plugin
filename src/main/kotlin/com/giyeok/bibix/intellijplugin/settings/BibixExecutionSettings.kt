package com.giyeok.bibix.intellijplugin.settings

import com.giyeok.bibix.daemon.BibixDaemonApiProto
import com.giyeok.bibix.daemon.BibixDaemonApiProto.IntellijProjectStructure
import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.system.BibixProjectResolverUtil
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.externalSystem.model.settings.ExternalSystemExecutionSettings

class BibixExecutionSettings(
  val projectDataNode: DataNode<ProjectData>
) : ExternalSystemExecutionSettings() {
  companion object {
    fun convertProject(
      projectPath: String,
      projectStructure: IntellijProjectStructure
    ): DataNode<ProjectData> {
      val projectName = projectStructure.project.name
      val projectData =
        ProjectData(
          BibixConstants.SYSTEM_ID,
          projectName,
          projectPath,
          projectStructure.project.path
        )
      val projectDataNode = DataNode(ProjectKeys.PROJECT, projectData, null)

      val moduleTypeId = BibixProjectResolverUtil.getDefaultModuleTypeId()

      val moduleNodeByName = mutableMapOf<String, DataNode<ModuleData>>()

      projectStructure.project.modulesList.forEach { module ->
        val moduleData = ModuleData(
          module.name,
          BibixConstants.SYSTEM_ID,
          moduleTypeId,
          module.name,
          "$projectPath/.idea",
          projectPath
        )
        val moduleNode = projectDataNode.createChild(ProjectKeys.MODULE, moduleData)

        module.contentRootsList.forEach { contentRoot ->
          val contentRootData = ContentRootData(BibixConstants.SYSTEM_ID, contentRoot.path)
          contentRootData.storePath(ExternalSystemSourceType.SOURCE, contentRoot.path)
          moduleNode.createChild(ProjectKeys.CONTENT_ROOT, contentRootData)
        }

        moduleNodeByName[module.name] = moduleNode
      }

      projectStructure.project.modulesList.forEach { module ->
        val moduleNode = moduleNodeByName.getValue(module.name)

        module.dependenciesList.forEach { dep ->
          when (dep.dependencyCase) {
            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.MAVEN_DEPENDENCY -> {
              val mavenDep = dep.mavenDependency
              val libraryData = LibraryData(
                BibixConstants.SYSTEM_ID,
                "Maven: ${mavenDep.group}:${mavenDep.artifact}:${mavenDep.version}"
              )
              libraryData.addPath(LibraryPathType.BINARY, mavenDep.path)
              moduleNode.createChild(ProjectKeys.LIBRARY, libraryData)

              val libraryDependencyData =
                LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.MODULE)
              moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDependencyData)
            }
            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.LIBRARY_DEPENDENCY -> {
              val libDep = dep.libraryDependency
              val libraryData = LibraryData(
                BibixConstants.SYSTEM_ID,
                "library ${libDep.path}"
              )
              // TODO binary?
              libraryData.addPath(LibraryPathType.BINARY, libDep.path)
              moduleNode.createChild(ProjectKeys.LIBRARY, libraryData)

              val libraryDependencyData =
                LibraryDependencyData(moduleNode.data, libraryData, LibraryLevel.MODULE)
              moduleNode.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDependencyData)
            }
            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.MODULE_DEPENDENCY -> {
              val dependingModuleData = moduleNodeByName[dep.moduleDependency]!!.data
              val moduleDepData = ModuleDependencyData(moduleNode.data, dependingModuleData)
              moduleNode.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDepData)
            }
            BibixDaemonApiProto.IntellijDependencyNode.DependencyCase.DEPENDENCY_NOT_SET, null -> {
              // ??
            }
          }
        }
      }

//    val scriptFile = File(File(projectPath), "build.bbx")
//    val scriptSource = try {
//      scriptFile.readText()
//    } catch (e: Exception) {
//      LOG.error("Failed to read the bibix build script: ${scriptFile.canonicalPath}", e)
//      throw e
//    }
//
//
//    val rootModuleData = ModuleData(
//      "Root Module",
//      BibixConstants.SYSTEM_ID,
//      moduleTypeId,
//      "Root Module",
//      "$projectPath/.idea",
//      projectPath
//    )
//    val rootModuleDataNode = projectDataNode.createChild(ProjectKeys.MODULE, rootModuleData)
//    val rootModuleContentRootData = ContentRootData(BibixConstants.SYSTEM_ID, projectPath)
//    rootModuleContentRootData.storePath(ExternalSystemSourceType.SOURCE, projectPath)
//    rootModuleDataNode.createChild(ProjectKeys.CONTENT_ROOT, rootModuleContentRootData)
//
//    val moduleFileDirectoryPath = "$projectPath/.idea/modules"
//
//    val moduleRootPath1 = "$projectPath/src"
//    val moduleData1 = ModuleData(
//      "${rootModuleData.id}:module1",
//      BibixConstants.SYSTEM_ID,
//      moduleTypeId,
//      "Module 123",
//      moduleFileDirectoryPath,
//      projectPath
//    )
//    val moduleDataNode1 = rootModuleDataNode.createChild(ProjectKeys.MODULE, moduleData1)
//
//    val contentRootData1 = ContentRootData(BibixConstants.SYSTEM_ID, moduleRootPath1)
//    contentRootData1.storePath(ExternalSystemSourceType.SOURCE, "$moduleRootPath1/main/kotlin")
//    moduleDataNode1.createChild(ProjectKeys.CONTENT_ROOT, contentRootData1)
//
//    val moduleRootPath2 = "$projectPath/bbb/src"
//    val moduleData2 = ModuleData(
//      "${rootModuleData.id}:module2",
//      BibixConstants.SYSTEM_ID,
//      moduleTypeId,
//      "Module 234",
//      moduleFileDirectoryPath,
//      projectPath
//    )
//    val moduleDataNode2 = rootModuleDataNode.createChild(ProjectKeys.MODULE, moduleData2)
//
//    val contentRootData2 = ContentRootData(BibixConstants.SYSTEM_ID, moduleRootPath2)
//    contentRootData2.storePath(ExternalSystemSourceType.SOURCE, "$moduleRootPath2/main/kotlin")
//    moduleDataNode2.createChild(ProjectKeys.CONTENT_ROOT, contentRootData2)
//
//    val moduleDependencyData = ModuleDependencyData(moduleData1, moduleData2)
//    moduleDependencyData.scope = DependencyScope.COMPILE
//    moduleDataNode1.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDependencyData)
//
//    val libraryData = LibraryData(BibixConstants.SYSTEM_ID, "dependency 345")
//    libraryData.addPath(LibraryPathType.BINARY, "$projectPath/lib/bibix-0.0.2.jar")
//    projectDataNode.createChild(ProjectKeys.LIBRARY, libraryData)
//
//    val libraryDependencyData =
//      LibraryDependencyData(moduleData1, libraryData, LibraryLevel.PROJECT)
//    moduleDataNode1.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDependencyData)
//    // projectDataNode.putUserData()
//
//    val taskData =
//      TaskData(BibixConstants.SYSTEM_ID, "BibixTaskTaskTask", projectPath, "Testing bibix task")
//    taskData.group = "build"
//    moduleDataNode1.createChild(ProjectKeys.TASK, taskData)

      return projectDataNode
    }
  }
}
