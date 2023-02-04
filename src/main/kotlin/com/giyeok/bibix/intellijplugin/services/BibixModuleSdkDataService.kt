package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractModuleDataService
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.impl.libraries.LibraryEx
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk
import org.jetbrains.plugins.scala.project.ScalaLibraryProperties
import org.jetbrains.plugins.scala.project.ScalaLibraryType
import scala.Option
import java.io.File

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
    applyScalaSdks(toImport, modelsProvider)
  }

  fun applyJdks(
    toImport: Collection<DataNode<BibixModuleSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val jdkNodes = toImport.filter { it.data is BibixJavaSdkData }
    val requiredJdkVersions = jdkNodes.map { (it.data as BibixJavaSdkData).jdkVersion }.distinct()
    val sdks = requiredJdkVersions.associateWith { sdkName ->
      lookupSdk { builder: SdkLookupBuilder ->
        builder
          .withSdkName(sdkName)
          .withSdkType(ExternalSystemJdkUtil.getJavaSdkType())
          .onDownloadableSdkSuggested { _: UnknownSdkDownloadableSdkFix? -> SdkLookupDecision.STOP }
      }
    }

    val projectJdkNode =
      jdkNodes.find { it.parent?.data is ProjectData && it.data is BibixJavaSdkData }

    val projectSdk = sdks[(projectJdkNode?.data as? BibixJavaSdkData)?.jdkVersion]

    if (projectSdk != null) {
      WriteCommandAction.runWriteCommandAction(project) {
        ProjectRootManager.getInstance(project).projectSdk = projectSdk
      }
    }

    for (jdkNode in jdkNodes) {
      val moduleNode = jdkNode.getParent(ModuleData::class.java) ?: continue
      val module = moduleNode.getUserData(AbstractModuleDataService.MODULE_KEY) ?: continue
      val sdkName = (jdkNode.data as BibixJavaSdkData).jdkVersion
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

  fun applyScalaSdks(
    toImport: Collection<DataNode<BibixModuleSdkData>>,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val scalaSdkNodeNames = toImport
      .filter { it.data is BibixScalaSdkData }
      .mapNotNull { it.parent?.data as? LibraryData }
      .associateBy { it.internalName }

    val scalaSdkLibs = modelsProvider.allLibraries.filter { scalaSdkNodeNames.contains(it.name) }
    scalaSdkLibs.distinct().forEach { library ->
      val sdkDataNode = scalaSdkNodeNames.getValue(library.name!!)
      val modModel =
        (modelsProvider.getModifiableLibraryModel(library) as LibraryEx.ModifiableModelEx)
      modModel.kind = ScalaLibraryType.`Kind$`.`MODULE$`
      val cpbuilder = scala.collection.immutable.`List$`.`MODULE$`.newBuilder<File>()
      sdkDataNode.getPaths(LibraryPathType.BINARY).map { File(it) }.forEach {
        cpbuilder.addOne(it)
      }
      modModel.properties = ScalaLibraryProperties.apply(
        Option.apply("2.13"),
        cpbuilder.result(),
        scala.collection.immutable.`List$`.`MODULE$`.empty(),
      )
    }
  }
}
