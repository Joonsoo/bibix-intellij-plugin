package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.project.AbstractNamedData
import kotlinx.serialization.Serializable

@Serializable
sealed class BibixUsingSdkVersionData(owner: ProjectSystemId, name: String) :
  AbstractNamedData(owner, name) {
  companion object {
    val KEY = Key.create(BibixUsingSdkVersionData::class.java, 650)
  }
}

@Serializable
class BibixUsingJdkVersionData(owner: ProjectSystemId, val jdkVersion: String) :
  BibixUsingSdkVersionData(owner, "bibix_using_jdk_version_data")

@Serializable
class BibixUsingKtJvmSdkVersionData(
  owner: ProjectSystemId,
  val sdkVersion: String,
) : BibixUsingSdkVersionData(owner, "bibix_using_ktjvm_sdk_version_data")

@Serializable
class BibixUsingScalaSdkVersionData(
  owner: ProjectSystemId,
  val sdkVersion: String,
) : BibixUsingSdkVersionData(owner, "bibix_using_scala_sdk_version_data")
