package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.project.AbstractNamedData
import java.io.Serializable

sealed class BibixSdkData(owner: ProjectSystemId, name: String) : AbstractNamedData(owner, name) {
  companion object {
    val KEY = Key.create(BibixSdkData::class.java, 600)
  }
}

class BibixJavaSdkData(owner: ProjectSystemId, val jdkVersion: String) :
  BibixSdkData(owner, "bibix_java_sdk_data")

//message KotlinJvmSdk {
//  string version = 1;
//  repeated string sdk_library_ids = 2;
//}
//
//message ScalaSdk {
//  string version = 1;
//  string scala_language_version = 2;
//  repeated string compiler_classpaths = 3;
//  repeated string sdk_library_ids = 4;
//}

@kotlinx.serialization.Serializable
data class KtJvmSdkData(
  val version: String,
  val sdkLibraryIds: List<String>
) : Serializable

@kotlinx.serialization.Serializable
data class ScalaSdkData(
  val version: String,
  val langVersion: String,
  val compilerClasspaths: List<String>,
  val sdkLibraryIds: List<String>
) : Serializable

class BibixKtJvmSdkData(owner: ProjectSystemId, val sdk: KtJvmSdkData) :
  BibixSdkData(owner, "bibix_ktjvm_sdk_data")

class BibixScalaSdkData(owner: ProjectSystemId, val sdk: ScalaSdkData) :
  BibixSdkData(owner, "bibix_scala_sdk_data")
