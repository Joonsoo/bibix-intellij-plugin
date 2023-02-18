//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmSynthetic
public inline fun bibixProjectInfo(block: com.giyeok.bibix.intellij.BibixProjectInfoKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo =
  com.giyeok.bibix.intellij.BibixProjectInfoKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.newBuilder()).apply { block() }._build()
public object BibixProjectInfoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo = _builder.build()

    /**
     * <code>string project_id = 1;</code>
     */
    public var projectId: kotlin.String
      @JvmName("getProjectId")
      get() = _builder.getProjectId()
      @JvmName("setProjectId")
      set(value) {
        _builder.setProjectId(value)
      }
    /**
     * <code>string project_id = 1;</code>
     */
    public fun clearProjectId() {
      _builder.clearProjectId()
    }

    /**
     * <code>string project_name = 2;</code>
     */
    public var projectName: kotlin.String
      @JvmName("getProjectName")
      get() = _builder.getProjectName()
      @JvmName("setProjectName")
      set(value) {
        _builder.setProjectName(value)
      }
    /**
     * <code>string project_name = 2;</code>
     */
    public fun clearProjectName() {
      _builder.clearProjectName()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class ModulesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     */
     public val modules: com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getModulesList()
      )
    /**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     * @param value The modules to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addModules")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.add(value: com.giyeok.bibix.intellij.BibixIntellijProto.Module) {
      _builder.addModules(value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     * @param value The modules to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignModules")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.plusAssign(value: com.giyeok.bibix.intellij.BibixIntellijProto.Module) {
      add(value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     * @param values The modules to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllModules")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.addAll(values: kotlin.collections.Iterable<com.giyeok.bibix.intellij.BibixIntellijProto.Module>) {
      _builder.addAllModules(values)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     * @param values The modules to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllModules")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.plusAssign(values: kotlin.collections.Iterable<com.giyeok.bibix.intellij.BibixIntellijProto.Module>) {
      addAll(values)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     * @param index The index to set the value at.
     * @param value The modules to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setModules")
    public operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.set(index: kotlin.Int, value: com.giyeok.bibix.intellij.BibixIntellijProto.Module) {
      _builder.setModules(index, value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.Module modules = 3;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearModules")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.Module, ModulesProxy>.clear() {
      _builder.clearModules()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class ExternalLibrariesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     */
     public val externalLibraries: com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getExternalLibrariesList()
      )
    /**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     * @param value The externalLibraries to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addExternalLibraries")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.add(value: com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary) {
      _builder.addExternalLibraries(value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     * @param value The externalLibraries to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignExternalLibraries")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.plusAssign(value: com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary) {
      add(value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     * @param values The externalLibraries to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllExternalLibraries")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.addAll(values: kotlin.collections.Iterable<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary>) {
      _builder.addAllExternalLibraries(values)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     * @param values The externalLibraries to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllExternalLibraries")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.plusAssign(values: kotlin.collections.Iterable<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary>) {
      addAll(values)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     * @param index The index to set the value at.
     * @param value The externalLibraries to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setExternalLibraries")
    public operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.set(index: kotlin.Int, value: com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary) {
      _builder.setExternalLibraries(index, value)
    }/**
     * <code>repeated .com.giyeok.bibix.intellij.ExternalLibrary external_libraries = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearExternalLibraries")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.intellij.BibixIntellijProto.ExternalLibrary, ExternalLibrariesProxy>.clear() {
      _builder.clearExternalLibraries()
    }
    /**
     * <code>.com.giyeok.bibix.intellij.Sdks sdks = 5;</code>
     */
    public var sdks: com.giyeok.bibix.intellij.BibixIntellijProto.Sdks
      @JvmName("getSdks")
      get() = _builder.getSdks()
      @JvmName("setSdks")
      set(value) {
        _builder.setSdks(value)
      }
    /**
     * <code>.com.giyeok.bibix.intellij.Sdks sdks = 5;</code>
     */
    public fun clearSdks() {
      _builder.clearSdks()
    }
    /**
     * <code>.com.giyeok.bibix.intellij.Sdks sdks = 5;</code>
     * @return Whether the sdks field is set.
     */
    public fun hasSdks(): kotlin.Boolean {
      return _builder.hasSdks()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.copy(block: com.giyeok.bibix.intellij.BibixProjectInfoKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo =
  com.giyeok.bibix.intellij.BibixProjectInfoKt.Dsl._create(this.toBuilder()).apply { block() }._build()
