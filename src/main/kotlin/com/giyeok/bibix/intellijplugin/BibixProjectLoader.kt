package com.giyeok.bibix.intellijplugin

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.project.ProjectData
import java.nio.file.Path

class BibixProjectLoader(val projectRoot: Path, val scriptName: String) {
  fun loadProjectStructure(): DataNode<ProjectData> {
    // ModuleStructAnalysisTests 참고
    TODO()
  }
}
