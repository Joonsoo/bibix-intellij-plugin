import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun properties(key: String) = project.findProperty(key).toString()

plugins {
  // Java support
  id("java")
  // Kotlin support
  id("org.jetbrains.kotlin.jvm") version "1.8.0"
  // Gradle IntelliJ Plugin
  id("org.jetbrains.intellij") version "1.12.0"
  // Gradle Changelog Plugin
  id("org.jetbrains.changelog") version "2.0.0"
  // Gradle Qodana Plugin
  id("org.jetbrains.qodana") version "0.1.13"
  // Gradle Kover Plugin
  id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

sourceSets {
  getByName("main") {
    java {
      srcDir("src/generated/proto/java")
      srcDir("src/generated/grpc/java")
    }
    `kotlin` {
      // kotlin???
      srcDir("src/generated/proto/kotlin")
      srcDir("src/generated/grpc/kotlin")
    }
  }
}

// Configure project's dependencies
repositories {
  mavenCentral()
}

dependencies {
  implementation("com.google.protobuf:protobuf-java:3.20.1")
  implementation("com.google.protobuf:protobuf-java-util:3.20.1")
  implementation("com.google.protobuf:protobuf-kotlin:3.20.1")
  implementation("io.grpc:grpc-services:1.47.0")
  implementation("io.grpc:grpc-netty-shaded:1.47.0")
  implementation("io.grpc:grpc-kotlin-stub:1.2.1")
  implementation(fileTree("dir" to "lib", "include" to listOf("*.jar")))
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
  pluginName.set(properties("pluginName"))
  version.set(properties("platformVersion"))
  type.set(properties("platformType"))

  // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
  // # Plugin Dependencies -> https://plugins.jetbrains.com/docs/intellij/plugin-dependencies.html
  plugins.set(listOf("com.intellij.java", "org.intellij.scala:2022.1.16"))
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
  version.set(properties("pluginVersion"))
  groups.set(emptyList())
}

// Configure Gradle Qodana Plugin - read more: https://github.com/JetBrains/gradle-qodana-plugin
qodana {
  cachePath.set(projectDir.resolve(".qodana").canonicalPath)
  reportPath.set(projectDir.resolve("build/reports/inspections").canonicalPath)
  saveReport.set(true)
  showReport.set(System.getenv("QODANA_SHOW_REPORT")?.toBoolean() ?: false)
}

tasks {
  // Set the JVM compatibility versions
  properties("javaVersion").let {
    withType<JavaCompile> {
      sourceCompatibility = it
      targetCompatibility = it
    }
    withType<KotlinCompile> {
      kotlinOptions.jvmTarget = it
    }
  }

  wrapper {
    gradleVersion = properties("gradleVersion")
  }

  patchPluginXml {
    version.set(properties("pluginVersion"))
    sinceBuild.set(properties("pluginSinceBuild"))
    untilBuild.set(properties("pluginUntilBuild"))

    // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
    pluginDescription.set(
      projectDir.resolve("README.md").readText().lines().run {
        val start = "<!-- Plugin description -->"
        val end = "<!-- Plugin description end -->"

        if (!containsAll(listOf(start, end))) {
          throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
        }
        subList(indexOf(start) + 1, indexOf(end))
      }.joinToString("\n").run { markdownToHTML(this) }
    )

    // Get the latest available change notes from the changelog file
//    changeNotes.set(provider {
//      changelog.run {
//        getOrNull(properties("pluginVersion")) ?: getLatest()
//      }.toHTML()
//    })
  }

  // Configure UI tests plugin
  // Read more: https://github.com/JetBrains/intellij-ui-test-robot
  runIdeForUiTests {
    systemProperty("robot-server.port", "8082")
    systemProperty("ide.mac.message.dialogs.as.sheets", "false")
    systemProperty("jb.privacy.policy.text", "<!--999.999-->")
    systemProperty("jb.consents.confirmation.enabled", "false")
    autoReloadPlugins.set(true)
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    dependsOn("patchChangelog")
    token.set(System.getenv("PUBLISH_TOKEN"))
    // pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
    // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
    // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
    channels.set(
      listOf(
        properties("pluginVersion").split('-').getOrElse(1) { "default" }.split('.').first()
      )
    )
  }
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.freeCompilerArgs += "-opt-in=org.mylibrary.OptInAnnotation"
}
