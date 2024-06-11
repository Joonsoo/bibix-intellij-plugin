package com.giyeok.bibix.intellijplugin.services

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.model.project.AbstractNamedData
import kotlinx.serialization.Serializable

@Serializable
class BibixNativeLibLocsData(
  owner: ProjectSystemId,
  val loc: String,
): AbstractNamedData(owner, "bibix_native_lib_locs") {
  companion object {
    val KEY = Key.create(BibixNativeLibLocsData::class.java, 600)
  }
}
