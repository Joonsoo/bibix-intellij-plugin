//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmSynthetic
public inline fun kotlinJvmSdk(block: com.giyeok.bibix.intellij.KotlinJvmSdkKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk =
  com.giyeok.bibix.intellij.KotlinJvmSdkKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk.newBuilder()).apply { block() }._build()
public object KotlinJvmSdkKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk = _builder.build()

    /**
     * <code>string version = 1;</code>
     */
    public var version: kotlin.String
      @JvmName("getVersion")
      get() = _builder.getVersion()
      @JvmName("setVersion")
      set(value) {
        _builder.setVersion(value)
      }
    /**
     * <code>string version = 1;</code>
     */
    public fun clearVersion() {
      _builder.clearVersion()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class SdkLibraryIdsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @return A list containing the sdkLibraryIds.
     */
    public val sdkLibraryIds: com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getSdkLibraryIdsList()
      )
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @param value The sdkLibraryIds to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addSdkLibraryIds")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.add(value: kotlin.String) {
      _builder.addSdkLibraryIds(value)
    }
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @param value The sdkLibraryIds to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignSdkLibraryIds")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @param values The sdkLibraryIds to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllSdkLibraryIds")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllSdkLibraryIds(values)
    }
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @param values The sdkLibraryIds to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllSdkLibraryIds")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * <code>repeated string sdk_library_ids = 2;</code>
     * @param index The index to set the value at.
     * @param value The sdkLibraryIds to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setSdkLibraryIds")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setSdkLibraryIds(index, value)
    }/**
     * <code>repeated string sdk_library_ids = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearSdkLibraryIds")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, SdkLibraryIdsProxy>.clear() {
      _builder.clearSdkLibraryIds()
    }}
}
@kotlin.jvm.JvmSynthetic
public inline fun com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk.copy(block: com.giyeok.bibix.intellij.KotlinJvmSdkKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.KotlinJvmSdk =
  com.giyeok.bibix.intellij.KotlinJvmSdkKt.Dsl._create(this.toBuilder()).apply { block() }._build()
