package com.github.joonsoo.bibixintellijplugin.services

import com.intellij.openapi.project.Project
import com.github.joonsoo.bibixintellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
