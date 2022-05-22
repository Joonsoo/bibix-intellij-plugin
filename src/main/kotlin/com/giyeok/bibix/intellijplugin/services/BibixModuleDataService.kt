package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ModuleData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.ProjectJdkTable

class BibixModuleDataService : AbstractProjectDataService<ModuleData, Project>() {
  private val LOG: Logger = Logger.getInstance(BibixModuleDataService::class.java)

  override fun getTargetDataKey(): Key<ModuleData> = ProjectKeys.MODULE

  override fun importData(
    toImport: Collection<DataNode<ModuleData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    LOG.warn("ModuleDataService.importData")
  }

  override fun postProcess(
    toImport: MutableCollection<out DataNode<ModuleData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val javaSdk = JavaSdk.getInstance()
    val jdkTable = ProjectJdkTable.getInstance()
    val jdks = jdkTable.getSdksOfType(javaSdk)
    LOG.warn("$jdkTable")
    LOG.warn("$jdks")
//    toImport.forEach { moduleDataNode ->
//      moduleDataNode.createChild(ModuleSdkData.KEY, ModuleSdkData("16"))
//    }
  }
}
