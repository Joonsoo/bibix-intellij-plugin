package com.giyeok.bibix.intellijplugin.project

import com.giyeok.bibix.intellijplugin.BibixConstants.SYSTEM_ID
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalModuleBuilder
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.StdModuleTypes
import com.intellij.openapi.roots.ModifiableRootModel

class BibixModuleBuilder : AbstractExternalModuleBuilder<BibixProjectSettings>(
  SYSTEM_ID,
  BibixProjectSettings()
) {
  val LOG: Logger = Logger.getInstance(BibixModuleBuilder::class.java)

  override fun getModuleType(): ModuleType<*> = StdModuleTypes.JAVA

  override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
    super.setupRootModel(modifiableRootModel)

    LOG.warn("setupRootModel")

    val project = modifiableRootModel.module.project
    val settings =
      ExternalSystemApiUtil.getSettings(project, SYSTEM_ID)

    settings.linkProject(externalProjectSettings)
  }

  override fun setupModule(module: Module) {
    super.setupModule(module)

    LOG.warn("setupModule")

    val project = module.project
    val settings =
      ExternalSystemApiUtil.getSettings(project, SYSTEM_ID)

    settings.linkProject(externalProjectSettings)
  }
}
