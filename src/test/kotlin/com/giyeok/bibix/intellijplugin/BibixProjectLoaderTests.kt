package com.giyeok.bibix.intellijplugin

import org.junit.Test
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

class BibixProjectLoaderTests {
  @Test
  fun test() {
    val testProject = Path("src/test/testproject")
    println(testProject.absolutePathString())
    val loader = BibixProjectLoader(testProject, "build.bbx")
    val projectNode = loader.loadProjectStructure()
    println(projectNode)
  }
}
