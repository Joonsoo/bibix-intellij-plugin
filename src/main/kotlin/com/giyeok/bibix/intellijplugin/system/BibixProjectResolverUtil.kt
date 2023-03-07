package com.giyeok.bibix.intellijplugin.system

object BibixProjectResolverUtil {
  fun getDefaultModuleTypeId(): String {
    // return ModuleTypeManager.getInstance().defaultModuleType.id
    // JavaModuleType.getModuleType().id
    return "JAVA_MODULE"
  }
}
