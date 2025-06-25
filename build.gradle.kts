plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "2.2.0"
  id("org.jetbrains.intellij.platform") // version "2.6.0"
}

group = "com.giyeok.bibix"
version = "0.1.0"

sourceSets {
  getByName("main") {
    java {
      srcDir("src/generated/proto/java")
      srcDir("src/generated/grpc/java")
    }
    kotlin {
      // kotlin???
      srcDir("src/generated/proto/kotlin")
      srcDir("src/generated/grpc/kotlin")
    }
  }
}

repositories {
  mavenCentral()

  intellijPlatform {
    defaultRepositories()
  }
}

dependencies {
  implementation("com.google.protobuf:protobuf-java:3.25.8")
  implementation("com.google.protobuf:protobuf-java-util:3.25.8")
  implementation("com.google.protobuf:protobuf-kotlin:3.25.8")
  implementation("io.grpc:grpc-services:1.73.0")
  implementation("io.grpc:grpc-protobuf:1.73.0")
  implementation("io.grpc:grpc-protobuf-lite:1.73.0")
  implementation("io.grpc:grpc-netty-shaded:1.73.0")
  implementation("io.grpc:grpc-kotlin-stub:1.4.3")
  implementation("io.grpc:grpc-util:1.73.0")
  implementation("io.perfmark:perfmark-api:0.27.0")

  intellijPlatform {
    intellijIdeaCommunity("2025.1.3")

    bundledPlugin("com.intellij.java")
    plugin("org.intellij.scala", "2025.1.27")
  }
}

intellijPlatform {
  pluginConfiguration {
    version = "0.1.0"

    ideaVersion {
      sinceBuild = "251"
      untilBuild = "251.*"
    }
  }

  signing {
    certificateChain = System.getenv("CERTIFICATE_CHAIN")
    privateKey = System.getenv("PRIVATE_KEY")
    password = System.getenv("PRIVATE_KEY_PASSWORD")
  }

  publishing {
    token = System.getenv("PUBLISH_TOKEN")
  }
}

//// Configure Gradle IntelliJ Plugin
//// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
//intellij {
//  version.set("2023.2")
//  type.set("IC") // Target IDE Platform
//
//  plugins.set(listOf("com.intellij.java", "org.intellij.scala:2023.2.17"))
//}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "19"
    targetCompatibility = "19"
  }
//  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions.jvmTarget = "17"
//  }

  jar {

  }
}
