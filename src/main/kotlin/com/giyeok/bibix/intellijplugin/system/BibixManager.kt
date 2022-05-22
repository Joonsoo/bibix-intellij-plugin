package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.giyeok.bibix.intellijplugin.settings.BibixLocalSettings
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.execution.configurations.SimpleJavaParameters
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.ExternalSystemManager
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.service.execution.ExternalSystemJdkUtil
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.intellij.openapi.externalSystem.task.ExternalSystemTaskManager
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ui.configuration.SdkLookupBuilder
import com.intellij.openapi.roots.ui.configuration.SdkLookupDecision
import com.intellij.openapi.roots.ui.configuration.UnknownSdkDownloadableSdkFix
import com.intellij.openapi.roots.ui.configuration.lookupSdk
import com.intellij.openapi.util.Pair
import com.intellij.util.Function

open class XX

class BibixManager : XX(), ExternalSystemManager<
  BibixProjectSettings,
  BibixSettingsListener,
  BibixSettings,
  BibixLocalSettings,
  BibixExecutionSettings> {
  val LOG: Logger = Logger.getInstance(BibixManager::class.java)

  override fun getSystemId(): ProjectSystemId = BibixConstants.SYSTEM_ID

  override fun getSettingsProvider(): Function<Project, BibixSettings> =
    Function { BibixSettings.getInstance(it) }

  override fun getLocalSettingsProvider(): Function<Project, BibixLocalSettings> =
    Function { BibixLocalSettings.getInstance(it) }

  override fun getExecutionSettingsProvider(): Function<Pair<Project, String>, BibixExecutionSettings> =
    Function { pair: Pair<Project, String> ->
      val project = pair.first
      val projectPath = pair.second
      BibixExecutionSettings()
    }

  override fun enhanceRemoteProcessing(parameters: SimpleJavaParameters) {
    // TODO("Not yet implemented")
  }

  override fun getProjectResolverClass(): Class<out ExternalSystemProjectResolver<BibixExecutionSettings>> =
    BibixProjectResolver::class.java

  override fun getTaskManagerClass(): Class<out ExternalSystemTaskManager<BibixExecutionSettings>> =
    BibixTaskManager::class.java

  override fun getExternalProjectDescriptor(): FileChooserDescriptor =
    FileChooserDescriptorFactory.createSingleFileDescriptor()
}
