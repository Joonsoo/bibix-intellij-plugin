plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "1.8.10"
  id("org.jetbrains.intellij") version "1.13.1"
}

group = "com.giyeok.bibix"
version = "0.0.5"

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
}

dependencies {
  implementation("com.google.protobuf:protobuf-java:3.22.0")
  implementation("com.google.protobuf:protobuf-java-util:3.22.0")
  implementation("com.google.protobuf:protobuf-kotlin:3.22.0")
  implementation("io.grpc:grpc-services:1.53.0")
  implementation("io.grpc:grpc-netty-shaded:1.53.0")
  implementation("io.grpc:grpc-kotlin-stub:1.3.0")
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
  version.set("2022.1.4")
  type.set("IC") // Target IDE Platform

  plugins.set(listOf("com.intellij.java", "org.intellij.scala:2022.1.16"))
}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "11"
    targetCompatibility = "11"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
  }

  jar {

  }

  patchPluginXml {
    version.set("0.0.5")
    sinceBuild.set("221")
    untilBuild.set("231.*")
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }
}
