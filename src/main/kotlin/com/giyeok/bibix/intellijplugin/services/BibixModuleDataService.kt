package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.project.AbstractNamedData

sealed class BibixModuleSdkData(owner: ProjectSystemId, name: String) :
  AbstractNamedData(owner, name) {
  companion object {
    val KEY = Key.create(BibixModuleSdkData::class.java, 650)
  }
}

class BibixModuleJdkData(owner: ProjectSystemId, val jdkVersion: String) :
  BibixModuleSdkData(owner, "bibix_module_jdk_data")

class BibixModuleKtJvmSdkData(
  owner: ProjectSystemId,
  val sdkVersion: String,
  val sdk: KtJvmSdkData
) : BibixModuleSdkData(owner, "bibix_module_ktjvm_sdk_data")

class BibixModuleScalaSdkData(
  owner: ProjectSystemId,
  val sdkVersion: String,
  val sdk: ScalaSdkData
) : BibixModuleSdkData(owner, "bibix_module_scala_sdk_data")
