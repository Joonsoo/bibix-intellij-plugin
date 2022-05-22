package icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object BibixIcons {
  private fun load(path: String): Icon = IconLoader.getIcon(path, BibixIcons::class.java)

  @JvmField
  val Bibix = load("/icons/bibix.png")

  @JvmField
  val BibixImport = load("/icons/bibixImport.png")
}
