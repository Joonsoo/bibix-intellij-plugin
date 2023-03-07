package com.giyeok.bibix.intellijplugin.system

import com.giyeok.bibix.intellijplugin.BibixConstants
import com.giyeok.bibix.intellijplugin.BibixSettingsListener
import com.giyeok.bibix.intellijplugin.settings.BibixExecutionSettings
import com.giyeok.bibix.intellijplugin.settings.BibixLocalSettings
import com.giyeok.bibix.intellijplugin.settings.BibixProjectSettings
import com.giyeok.bibix.intellijplugin.settings.BibixSettings
import com.intellij.execution.configurations.SimpleJavaParameters
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.ExternalSystemAutoImportAware
import com.intellij.openapi.externalSystem.ExternalSystemManager
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.intellij.openapi.externalSystem.task.ExternalSystemTaskManager
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.util.Pair
import com.intellij.util.Function
import com.intellij.util.PathUtil

open class XX

class BibixManager : XX(),
  ExternalSystemAutoImportAware,
//  ExternalSystemConfigurableAware,
  ExternalSystemManager<
    BibixProjectSettings,
    BibixSettingsListener,
    BibixSettings,
    BibixLocalSettings,
    BibixExecutionSettings>,
  StartupActivity {
  val LOG: Logger = Logger.getInstance(BibixManager::class.java)

  override fun getSystemId(): ProjectSystemId = BibixConstants.SYSTEM_ID

  override fun getSettingsProvider(): Function<Project, BibixSettings> =
    Function { project ->
      LOG.warn("getSettingsProvider ${project.basePath}")
      BibixSettings.getInstance(project)
    }

  override fun getLocalSettingsProvider(): Function<Project, BibixLocalSettings> =
    Function { project ->
      LOG.warn("getLocalSettingsProvider ${project.basePath}")
      BibixLocalSettings.getInstance(project)
    }

  override fun getExecutionSettingsProvider(): Function<Pair<Project, String>, BibixExecutionSettings> =
    Function { pair: Pair<Project, String> ->
      LOG.warn("getExecutionSettingsProvider $pair")
      BibixExecutionSettings()
    }

  override fun enhanceRemoteProcessing(parameters: SimpleJavaParameters) {
    val classes = listOf(
      // com/google/protobuf/protobuf-java/3.22.0/protobuf-java-3.22.0.jar
      com.google.protobuf.AbstractMessage::class.java,
      // com/google/protobuf/protobuf-java-util/3.22.0/protobuf-java-util-3.22.0.jar
      com.google.protobuf.util.Durations::class.java,
      // com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar
      javax.annotation.CheckForNull::class.java,
      // com/google/code/gson/gson/2.8.9/gson-2.8.9.jar
      com.google.gson.FieldNamingPolicy::class.java,
      // com/google/errorprone/error_prone_annotations/2.11.0/error_prone_annotations-2.11.0.jar
      com.google.errorprone.annotations.CanIgnoreReturnValue::class.java,
      // com/google/guava/guava/31.1-jre/guava-31.1-jre.jar
      com.google.common.annotations.Beta::class.java,
      // com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar
      // org/checkerframework/checker-qual/3.12.0/checker-qual-3.12.0.jar
      org.checkerframework.checker.builder.qual.CalledMethods::class.java,
      // com/google/j2objc/j2objc-annotations/1.3/j2objc-annotations-1.3.jar
      com.google.j2objc.annotations.AutoreleasePool::class.java,
      // com/google/protobuf/protobuf-kotlin/3.22.0/protobuf-kotlin-3.22.0.jar
      com.google.protobuf.AnyKt::class.java,
      // io/grpc/grpc-services/1.53.0/grpc-services-1.53.0.jar
      io.grpc.channelz.v1.GetSocketResponseOrBuilder::class.java,
      // io/grpc/grpc-protobuf/1.53.0/grpc-protobuf-1.53.0.jar
      io.grpc.protobuf.ProtoServiceDescriptorSupplier::class.java,
      // io/grpc/grpc-api/1.53.0/grpc-api-1.53.0.jar
      io.grpc.MethodDescriptor::class.java,
      // io/grpc/grpc-context/1.53.0/grpc-context-1.53.0.jar
      io.grpc.Context::class.java,
      // com/google/api/grpc/proto-google-common-protos/2.9.0/proto-google-common-protos-2.9.0.jar
      com.google.geo.type.Viewport::class.java,
      // io/grpc/grpc-protobuf-lite/1.53.0/grpc-protobuf-lite-1.53.0.jar
      io.grpc.protobuf.lite.ProtoLiteUtils::class.java,
      // io/grpc/grpc-stub/1.53.0/grpc-stub-1.53.0.jar
      io.grpc.stub.ServerCalls::class.java,
      // io/grpc/grpc-core/1.53.0/grpc-core-1.53.0.jar
      io.grpc.inprocess.InProcessChannelBuilder::class.java,
      // io/grpc/grpc-netty-shaded/1.53.0/grpc-netty-shaded-1.53.0.jar
      io.grpc.netty.shaded.io.grpc.netty.InternalNettyChannelCredentials::class.java,
      // io/grpc/grpc-kotlin-stub/1.3.0/grpc-kotlin-stub-1.3.0.jar
      io.grpc.kotlin.ClientCalls::class.java,
      // com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar
      com.google.common.util.concurrent.internal.InternalFutureFailureAccess::class.java,
      // com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar
      // org/checkerframework/checker-qual/3.12.0/checker-qual-3.12.0.jar
      org.checkerframework.checker.builder.qual.CalledMethods::class.java,
      // org/checkerframework/checker-compat-qual/2.5.5/checker-compat-qual-2.5.5.jar
      // org.checkerframework.checker.nullness.compatqual.NullableType::class.java,
      // javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar
      javax.annotation.sql.DataSourceDefinitions::class.java,
    )

    classes.forEach {
      val jarPath = PathUtil.getJarPathForClass(it)
      parameters.classPath.addFirst(jarPath)
    }
    LOG.warn("${parameters.classPath}")
  }

  override fun getProjectResolverClass(): Class<out ExternalSystemProjectResolver<BibixExecutionSettings>> {
    LOG.warn("getProjectResolverClass")
    return BibixProjectResolver::class.java
  }

  override fun getTaskManagerClass(): Class<out ExternalSystemTaskManager<BibixExecutionSettings>> =
    BibixTaskManager::class.java

  override fun getExternalProjectDescriptor(): FileChooserDescriptor =
    FileChooserDescriptorFactory.createSingleFileDescriptor()

  override fun getAffectedExternalProjectPath(
    changedFileOrDirPath: String,
    project: Project
  ): String? {
    LOG.warn("getAffectedExternalProjectPath $changedFileOrDirPath ${project.basePath}")
    return changedFileOrDirPath
  }

  override fun runActivity(project: Project) {
  }
}
