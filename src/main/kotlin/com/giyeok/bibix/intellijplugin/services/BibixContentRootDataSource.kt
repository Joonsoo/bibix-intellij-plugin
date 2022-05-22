package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ContentRootData
import com.intellij.openapi.externalSystem.model.project.ModuleData
import com.intellij.openapi.externalSystem.model.project.ModuleSdkData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.ContentEntry

class BibixContentRootDataSource : AbstractProjectDataService<ContentRootData, ContentEntry>() {
  private val LOG: Logger = Logger.getInstance(BibixModuleDataService::class.java)

  override fun getTargetDataKey(): Key<ContentRootData> = ProjectKeys.CONTENT_ROOT

  override fun importData(
    toImport: MutableCollection<out DataNode<ContentRootData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val byModule = ExternalSystemApiUtil.groupBy(toImport, ModuleData::class.java)
    LOG.warn("$byModule")
  }
}
