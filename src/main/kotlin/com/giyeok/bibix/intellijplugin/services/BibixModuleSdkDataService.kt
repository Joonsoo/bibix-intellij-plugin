package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.project.ModuleData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractModuleDataService
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk

// 모듈이 사용하는 SDK를 설정하는 서비스
class BibixModuleSdkDataService : AbstractProjectDataService<BibixModuleSdkData, Project>() {
  override fun getTargetDataKey(): Key<BibixModuleSdkData> = BibixModuleSdkData.KEY

  override fun importData(
    toImport: MutableCollection<out DataNode<BibixModuleSdkData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    super.importData(toImport, projectData, project, modelsProvider)

    applyJdks(toImport, project, modelsProvider)
    applyKtJvmSdks(toImport, project, modelsProvider)
    applyScalaSdks(toImport, project, modelsProvider)
  }

  fun applyJdks(
    toImport: Collection<DataNode<BibixModuleSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val jdkNodes = toImport.filter { it.data is BibixModuleJdkData }
    val requiredJdkVersions = jdkNodes.map { (it.data as BibixModuleJdkData).jdkVersion }.distinct()
    val sdks = requiredJdkVersions.associateWith { sdkName ->
      lookupSdk { builder: SdkLookupBuilder ->
        builder
          .withSdkName(sdkName)
          .withSdkType(ExternalSystemJdkUtil.getJavaSdkType())
          .onDownloadableSdkSuggested { _: UnknownSdkDownloadableSdkFix? -> SdkLookupDecision.CONTINUE }
      }
    }

    val projectJdkNode =
      jdkNodes.find { it.parent?.data is ProjectData && it.data is BibixModuleJdkData }

    val projectSdk = sdks[(projectJdkNode?.data as? BibixModuleJdkData)?.jdkVersion]

    if (projectSdk != null) {
      WriteCommandAction.runWriteCommandAction(project) {
        ProjectRootManager.getInstance(project).projectSdk = projectSdk
      }
    }

    for (jdkNode in jdkNodes) {
      val moduleNode = jdkNode.getParent(ModuleData::class.java) ?: continue
      val module = moduleNode.getUserData(AbstractModuleDataService.MODULE_KEY) ?: continue
      val sdkName = (jdkNode.data as BibixModuleJdkData).jdkVersion
      val sdk = sdks[sdkName]

      val modifiableRootModel = modelsProvider.getModifiableRootModel(module)
      if (modifiableRootModel.sdk != null) {
        continue
      }
      when {
        projectSdk == sdk -> modifiableRootModel.inheritSdk()
        sdk == null -> modifiableRootModel.setInvalidSdk(sdkName, "jdk")
        else -> modifiableRootModel.sdk = sdk
      }
    }
  }

  fun applyKtJvmSdks(
    toImport: Collection<DataNode<BibixModuleSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val sdkNodes = toImport.filter { it.data is BibixModuleKtJvmSdkData }
    for (sdkNode in sdkNodes) {
      val moduleNode = sdkNode.getParent(ModuleData::class.java) ?: continue
      val module = moduleNode.getUserData(AbstractModuleDataService.MODULE_KEY) ?: continue

      val modifiableRootModel = modelsProvider.getModifiableRootModel(module)
      println("$module, $sdkNode")
    }
  }

  fun applyScalaSdks(
    toImport: Collection<DataNode<BibixModuleSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val sdkNodes = toImport.filter { it.data is BibixModuleScalaSdkData }

    for (sdkNode in sdkNodes) {
      val moduleNode = sdkNode.getParent(ModuleData::class.java) ?: continue
      val module = moduleNode.getUserData(AbstractModuleDataService.MODULE_KEY) ?: continue

      val modifiableRootModel = modelsProvider.getModifiableRootModel(module)
      println("$module, $sdkNode")
    }
  }
}
