package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.model.task.TaskData
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.intellij.openapi.roots.DependencyScope
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk

class BibixProjectResolver : ExternalSystemProjectResolver<BibixExecutionSettings> {
  private val LOG: Logger = Logger.getInstance(BibixProjectResolver::class.java)

  override fun resolveProjectInfo(
    id: ExternalSystemTaskId,
    projectPath: String,
    isPreviewMode: Boolean,
    settings: BibixExecutionSettings?,
    listener: ExternalSystemTaskNotificationListener
  ): DataNode<ProjectData> {
    val projectName = "Bibix Test Project"
    val projectData = ProjectData(BibixConstants.SYSTEM_ID, projectName, projectPath, projectPath)
    val projectDataNode = DataNode(ProjectKeys.PROJECT, projectData, null)

    val moduleTypeId = BibixProjectResolverUtil.getDefaultModuleTypeId()

    val rootModuleData = ModuleData(
      "Root Module",
      BibixConstants.SYSTEM_ID,
      moduleTypeId,
      "Root Module",
      "$projectPath/.idea",
      projectPath
    )
    val rootModuleDataNode = projectDataNode.createChild(ProjectKeys.MODULE, rootModuleData)
    val rootModuleContentRootData = ContentRootData(BibixConstants.SYSTEM_ID, projectPath)
    rootModuleContentRootData.storePath(ExternalSystemSourceType.SOURCE, projectPath)
    rootModuleDataNode.createChild(ProjectKeys.CONTENT_ROOT, rootModuleContentRootData)

    val moduleFileDirectoryPath = "$projectPath/.idea/modules"

    val moduleRootPath1 = "$projectPath/src"
    val moduleData1 = ModuleData(
      "${rootModuleData.id}:module1",
      BibixConstants.SYSTEM_ID,
      moduleTypeId,
      "Module 123",
      moduleFileDirectoryPath,
      projectPath
    )
    val moduleDataNode1 = rootModuleDataNode.createChild(ProjectKeys.MODULE, moduleData1)

    val contentRootData1 = ContentRootData(BibixConstants.SYSTEM_ID, moduleRootPath1)
    contentRootData1.storePath(ExternalSystemSourceType.SOURCE, "$moduleRootPath1/main/kotlin")
    moduleDataNode1.createChild(ProjectKeys.CONTENT_ROOT, contentRootData1)

    val moduleRootPath2 = "$projectPath/bbb/src"
    val moduleData2 = ModuleData(
      "${rootModuleData.id}:module2",
      BibixConstants.SYSTEM_ID,
      moduleTypeId,
      "Module 234",
      moduleFileDirectoryPath,
      projectPath
    )
    val moduleDataNode2 = rootModuleDataNode.createChild(ProjectKeys.MODULE, moduleData2)

    val contentRootData2 = ContentRootData(BibixConstants.SYSTEM_ID, moduleRootPath2)
    contentRootData2.storePath(ExternalSystemSourceType.SOURCE, "$moduleRootPath2/main/kotlin")
    moduleDataNode2.createChild(ProjectKeys.CONTENT_ROOT, contentRootData2)

    val moduleDependencyData = ModuleDependencyData(moduleData1, moduleData2)
    moduleDependencyData.scope = DependencyScope.COMPILE
    moduleDataNode1.createChild(ProjectKeys.MODULE_DEPENDENCY, moduleDependencyData)

    val libraryData = LibraryData(BibixConstants.SYSTEM_ID, "dependency 345")
    libraryData.addPath(LibraryPathType.BINARY, "$projectPath/lib/bibix-0.0.2.jar")
    projectDataNode.createChild(ProjectKeys.LIBRARY, libraryData)

    val libraryDependencyData =
      LibraryDependencyData(moduleData1, libraryData, LibraryLevel.PROJECT)
    moduleDataNode1.createChild(ProjectKeys.LIBRARY_DEPENDENCY, libraryDependencyData)
    // projectDataNode.putUserData()

    val taskData =
      TaskData(BibixConstants.SYSTEM_ID, "BibixTaskTaskTask", projectPath, "Testing bibix task")
    taskData.group = "build"
    moduleDataNode1.createChild(ProjectKeys.TASK, taskData)

    return projectDataNode
  }

  override fun cancelTask(
    taskId: ExternalSystemTaskId,
    listener: ExternalSystemTaskNotificationListener
  ): Boolean {
    return true
  }
}
