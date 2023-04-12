package com.giyeok.bibix.intellijplugin.projectImport

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.intellij.externalSystem.JavaProjectData
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.ProjectDataManager
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportBuilder
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import icons.BibixIcons
import java.io.File
import javax.swing.Icon

class BibixProjectImportBuilder:
  AbstractExternalProjectImportBuilder<ImportFromBibixControl>(
    ProjectDataManager.getInstance(),
    { ImportFromBibixControl() },
    BibixConstants.SYSTEM_ID
  ) {
  val LOG = Logger.getInstance(BibixProjectImportBuilder::class.java)

  override fun getName(): String = "PROJECT NAME"

  override fun getIcon(): Icon = BibixIcons.Bibix

  override fun doPrepare(context: WizardContext) {
    LOG.warn("doPrepare $fileToImport")
    val pathToUse = fileToImport

    val importFromBibixControl = getControl(context.project)
    importFromBibixControl.setLinkedProjectPath(pathToUse)
  }

  override fun beforeCommit(dataNode: DataNode<ProjectData>, project: Project) {
    LOG.warn("beforeCommit $fileToImport")

    val javaProjectNode = ExternalSystemApiUtil.find(dataNode, JavaProjectData.KEY) ?: return

    val externalLanguageLevel = javaProjectNode.data.languageLevel
    val languageLevelExtension = LanguageLevelProjectExtension.getInstance(project)
    if (externalLanguageLevel != languageLevelExtension.languageLevel) {
      languageLevelExtension.languageLevel = externalLanguageLevel
    }
  }

  override fun getExternalProjectConfigToUse(file: File): File =
    if (file.isDirectory) file else file.parentFile

  override fun applyExtraSettings(context: WizardContext) {
    LOG.warn("applyExtraSettings $fileToImport")

    val node = externalProjectNode ?: return

//    val javaProjectNode = ExternalSystemApiUtil.find(node, JavaProjectData.KEY)
//    if (javaProjectNode != null) {
//      val data = javaProjectNode.data
//      context.compilerOutputDirectory = data.compileOutputPath
//      val version = data.jdkVersion
//      val jdk = findJdk(version)
//      if (jdk != null) {
//        context.projectJdk = jdk
//      }
//    }
  }
//
//  override fun getList(): List<Any> = emptyList()
//
//  override fun isMarked(element: Any?): Boolean = true
//
//  override fun setOpenProjectSettingsAfter(on: Boolean) {
//  }
//
//  override fun setFileToImport(path: String) {
//    super.setFileToImport(path)
//  }
//
//  override fun createProject(name: String?, path: String?): Project? {
//    return super.createProject(name, path)
//  }
//
//  override fun commit(
//    project: Project,
//    model: ModifiableModuleModel?,
//    modulesProvider: ModulesProvider?,
//    artifactModel: ModifiableArtifactModel?
//  ): List<Module> {
//    linkAndRefreshBibixProject(fileToImport, project)
//    return emptyList()
//  }
}
