package com.giyeok.bibix.intellijplugin.system

import com.intellij.openapi.module.JavaModuleType
import com.intellij.openapi.module.ModuleTypeManager

object BibixProjectResolverUtil {
  fun getDefaultModuleTypeId(): String {
    // return ModuleTypeManager.getInstance().defaultModuleType.id
    // JavaModuleType.getModuleType().id
    return "JAVA_MODULE"
  }
}
