package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.project.AbstractNamedData

sealed class BibixModuleSdkData(owner: ProjectSystemId, name: String) :
  AbstractNamedData(owner, name) {
  companion object {
    val KEY = Key.create(BibixModuleSdkData::class.java, 600)
  }
}

class BibixJavaSdkData(owner: ProjectSystemId, val jdkVersion: String) :
  BibixModuleSdkData(owner, "bibix_java_sdk_data")

class BibixScalaSdkData(owner: ProjectSystemId, val libraryName: String, val scalaVersion: String) :
  BibixModuleSdkData(owner, "bibix_scala_sdk_data")
