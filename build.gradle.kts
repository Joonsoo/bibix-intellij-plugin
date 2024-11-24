plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "1.9.21"
  id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "com.giyeok.bibix"
version = "0.0.11"

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
  intellijPlatform {
    intellijIdeaCommunity("2024.3")

    bundledPlugin("com.intellij.java")
    plugin("org.intellij.scala", "2024.3.18")

    instrumentationTools()
  }
  implementation("com.google.protobuf:protobuf-java:3.25.3")
  implementation("com.google.protobuf:protobuf-java-util:3.25.3")
  implementation("com.google.protobuf:protobuf-kotlin:3.25.3")
  implementation("com.google.guava:guava:33.1.0-jre")

  implementation("io.grpc:grpc-services:1.53.0")
  implementation("io.grpc:grpc-netty-shaded:1.53.0")
  implementation("io.grpc:grpc-kotlin-stub:1.3.0")

  // https://mvnrepository.com/artifact/io.perfmark/perfmark-api
  implementation("io.perfmark:perfmark-api:0.27.0")
}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
  }

  jar {

  }

  patchPluginXml {
    version = "0.0.12"
    sinceBuild.set("243")
    untilBuild.set("243.*")
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
