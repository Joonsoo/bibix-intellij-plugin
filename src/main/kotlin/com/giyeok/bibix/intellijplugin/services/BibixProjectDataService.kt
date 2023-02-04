package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.model.project.ProjectSdkData
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk

class BibixProjectDataService : AbstractProjectDataService<ProjectData, Project>() {
  private val LOG: Logger = Logger.getInstance(BibixProjectDataService::class.java)

  override fun getTargetDataKey(): Key<ProjectData> = ProjectKeys.PROJECT

  override fun importData(
    toImport: MutableCollection<out DataNode<ProjectData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    LOG.warn("BibixProjectDataService")
  }

  override fun postProcess(
    toImport: Collection<DataNode<ProjectData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
//    val sdkName = "1.8"
//    val sdk = lookupSdk { builder: SdkLookupBuilder ->
//      builder
//        .withSdkName(sdkName)
//        .withSdkType(ExternalSystemJdkUtil.getJavaSdkType())
//        .onDownloadableSdkSuggested { _: UnknownSdkDownloadableSdkFix? -> SdkLookupDecision.STOP }
//    }
//    ProjectJdkTable.getInstance().allJdks
//    if (sdk != null) {
//      WriteCommandAction.runWriteCommandAction(project) {
//        toImport.forEach { projectDataNode ->
//          projectDataNode.createChild(ProjectSdkData.KEY, ProjectSdkData(sdk.name))
//          ProjectRootManager.getInstance(project).projectSdk = sdk
//        }
//      }
//    }
  }
}
