package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ModuleData
import com.intellij.openapi.externalSystem.model.project.ModuleSdkData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk

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

    val javaSdk = JavaSdk.getInstance()
    val jdkTable = ProjectJdkTable.getInstance()
    val jdks = jdkTable.getSdksOfType(javaSdk)
    LOG.warn("$jdkTable")
    LOG.warn("$jdks")

    val sdkName = "1.8"
    val sdk = lookupSdk { builder: SdkLookupBuilder ->
      builder
        .withSdkName(sdkName)
        .withSdkType(ExternalSystemJdkUtil.getJavaSdkType())
        .onDownloadableSdkSuggested { _: UnknownSdkDownloadableSdkFix? -> SdkLookupDecision.STOP }
    }
    if (sdk != null) {
      WriteCommandAction.runWriteCommandAction(project) {
        toImport.forEach { moduleDataNode ->
          moduleDataNode.createChild(ModuleSdkData.KEY, ModuleSdkData(sdk.name))
          ProjectRootManager.getInstance(project).projectSdk = sdk
        }
      }
    }
  }
}
