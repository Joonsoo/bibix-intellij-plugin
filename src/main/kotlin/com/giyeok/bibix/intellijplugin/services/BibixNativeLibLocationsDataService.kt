package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.project.LibraryData
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.NativeLibraryOrderRootType

class BibixNativeLibLocationsDataService:
  AbstractProjectDataService<BibixNativeLibLocsData, Project>() {
  override fun getTargetDataKey(): Key<BibixNativeLibLocsData> = BibixNativeLibLocsData.KEY

  override fun importData(
    toImport: MutableCollection<out DataNode<BibixNativeLibLocsData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    super.importData(toImport, projectData, project, modelsProvider)

    for (dataNode in toImport) {
      val parentLib = dataNode.parent?.data as? LibraryData
      if (parentLib != null) {
        val targetLib =
          modelsProvider.allLibraries.find { it.name?.endsWith(parentLib.externalName) ?: false }
        val libModel = modelsProvider.getModifiableLibraryModel(targetLib)
        libModel.addRoot("file://" + dataNode.data.loc, NativeLibraryOrderRootType.getInstance())
      }
    }
  }
}
