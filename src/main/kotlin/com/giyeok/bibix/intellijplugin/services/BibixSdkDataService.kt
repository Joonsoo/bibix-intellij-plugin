package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.project.*
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractModuleDataService
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectEx
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.impl.libraries.LibraryEx
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk
import org.jetbrains.plugins.scala.project.ScalaLibraryProperties
import org.jetbrains.plugins.scala.project.ScalaLibraryType
import scala.Option
import java.io.File

// 프로젝트에 사용할 수 있는 kotlin, scala SDK를 라이브러리로 추가해주는 서비스
class BibixSdkDataService : AbstractProjectDataService<BibixSdkData, Project>() {
  override fun getTargetDataKey(): Key<BibixSdkData> = BibixSdkData.KEY

  override fun importData(
    toImport: MutableCollection<out DataNode<BibixSdkData>>,
    projectData: ProjectData?,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    super.importData(toImport, projectData, project, modelsProvider)

    applyKtJvmSdks(toImport, project, modelsProvider)
    applyScalaSdks(toImport, project, modelsProvider)
  }

  fun applyKtJvmSdks(
    toImport: Collection<DataNode<BibixSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val sdkNodes = toImport.filter { it.data is BibixKtJvmSdkData }
    println(sdkNodes)
//    val requiredSdkVersions = sdkNodes.map { (it.data as BibixKtJvmSdkData).sdk.version }.distinct()
//    val sdks = requiredSdkVersions.associateWith { sdkName ->
//      lookupSdk { builder: SdkLookupBuilder ->
//        builder.withSdkName(sdkName)
//          .onDownloadableSdkSuggested { _: UnknownSdkDownloadableSdkFix? -> SdkLookupDecision.CONTINUE }
//      }
//    }
//
//    val allSdks = ProjectJdkTable.getInstance().allJdks
//    println(allSdks)
//
//    for (sdkNode in sdkNodes) {
//      val moduleNode = sdkNode.getParent(ModuleData::class.java) ?: continue
//      val module = moduleNode.getUserData(AbstractModuleDataService.MODULE_KEY) ?: continue
//
//      val modifiableRootModel = modelsProvider.getModifiableRootModel(module)
//      if (modifiableRootModel.sdk != null) {
//        continue
//      }
//
//      val sdkName = (sdkNode.data as BibixKtJvmSdkData).sdkVersion
//      val sdk = sdks[sdkName]
//
//      if (sdk == null) {
//        modifiableRootModel.setInvalidSdk(sdkName, "kotlin sdk")
//      } else {
//        modifiableRootModel.sdk = sdk
//      }
//    }
  }

  fun applyScalaSdks(
    toImport: Collection<DataNode<BibixSdkData>>,
    project: Project,
    modelsProvider: IdeModifiableModelsProvider
  ) {
    val sdkNodes = toImport.filter { it.data is BibixScalaSdkData }
    println(sdkNodes)

    sdkNodes.forEach { sdkNode ->
      val data = sdkNode.data as BibixScalaSdkData
      data.sdk.sdkLibraryIds.forEach { libraryId ->
        val sdkLibrary = modelsProvider.allLibraries.find { it.name?.contains(libraryId) ?: false }
        if (sdkLibrary != null) {
          val libraryModel =
            (modelsProvider.getModifiableLibraryModel(sdkLibrary) as LibraryEx.ModifiableModelEx)
          libraryModel.kind = ScalaLibraryType.`Kind$`.`MODULE$`
          val cpbuilder = scala.collection.immutable.`List$`.`MODULE$`.newBuilder<File>()
//          sdkNode.getPaths(LibraryPathType.BINARY).map { File(it) }.forEach {
//            cpbuilder.addOne(it)
//          }
          val scalaLibProps = ScalaLibraryProperties.apply(
            Option.apply("2.13"),
            cpbuilder.result(),
            scala.collection.immutable.`List$`.`MODULE$`.empty(),
          )
          val compilerCpBuilder = scala.collection.immutable.`List$`.`MODULE$`.newBuilder<File>()
          data.sdk.compilerClasspaths.forEach { compilerCp ->
            compilerCpBuilder.addOne(File(compilerCp))
          }
          scalaLibProps.`compilerClasspath_$eq`(compilerCpBuilder.result())
          libraryModel.properties = scalaLibProps
        }
      }
    }
  }
}