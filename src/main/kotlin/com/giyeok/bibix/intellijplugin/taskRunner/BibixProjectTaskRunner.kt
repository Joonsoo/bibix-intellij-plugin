package com.giyeok.bibix.intellijplugin.taskRunner

import com.intellij.task.ProjectTask
import com.intellij.task.ProjectTaskRunner

class BibixProjectTaskRunner : ProjectTaskRunner() {
  override fun canRun(projectTask: ProjectTask): Boolean {
    return true
  }
}