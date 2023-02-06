//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmName("-initializebuildTargetsReq")
inline fun buildTargetsReq(block: com.giyeok.bibix.intellij.BuildTargetsReqKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq =
  com.giyeok.bibix.intellij.BuildTargetsReqKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.newBuilder()).apply { block() }._build()
object BuildTargetsReqKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq = _builder.build()

    /**
     * <code>string project_id = 1;</code>
     */
    var projectId: kotlin.String
      @JvmName("getProjectId")
      get() = _builder.getProjectId()
      @JvmName("setProjectId")
      set(value) {
        _builder.setProjectId(value)
      }
    /**
     * <code>string project_id = 1;</code>
     */
    fun clearProjectId() {
      _builder.clearProjectId()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class BuildTargetsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated string build_targets = 2;</code>
     * @return A list containing the buildTargets.
     */
     val buildTargets: com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getBuildTargetsList()
      )
    /**
     * <code>repeated string build_targets = 2;</code>
     * @param value The buildTargets to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addBuildTargets")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.add(value: kotlin.String) {
      _builder.addBuildTargets(value)
    }
    /**
     * <code>repeated string build_targets = 2;</code>
     * @param value The buildTargets to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignBuildTargets")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * <code>repeated string build_targets = 2;</code>
     * @param values The buildTargets to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllBuildTargets")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllBuildTargets(values)
    }
    /**
     * <code>repeated string build_targets = 2;</code>
     * @param values The buildTargets to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllBuildTargets")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * <code>repeated string build_targets = 2;</code>
     * @param index The index to set the value at.
     * @param value The buildTargets to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setBuildTargets")
    operator fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setBuildTargets(index, value)
    }/**
     * <code>repeated string build_targets = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearBuildTargets")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, BuildTargetsProxy>.clear() {
      _builder.clearBuildTargets()
    }}
}
@kotlin.jvm.JvmSynthetic
inline fun com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.copy(block: com.giyeok.bibix.intellij.BuildTargetsReqKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq =
  com.giyeok.bibix.intellij.BuildTargetsReqKt.Dsl._create(this.toBuilder()).apply { block() }._build()
