// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmName("-initializebuildTargetsUpdate")
public inline fun buildTargetsUpdate(block: com.giyeok.bibix.intellij.BuildTargetsUpdateKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate =
  com.giyeok.bibix.intellij.BuildTargetsUpdateKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.newBuilder()).apply { block() }._build()
/**
 * ```
 * TODO
 * ```
 *
 * Protobuf type `com.giyeok.bibix.intellij.BuildTargetsUpdate`
 */
public object BuildTargetsUpdateKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate = _builder.build()
  }
}
@kotlin.jvm.JvmSynthetic
@com.google.errorprone.annotations.CheckReturnValue
public inline fun com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.copy(block: com.giyeok.bibix.intellij.BuildTargetsUpdateKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate =
  com.giyeok.bibix.intellij.BuildTargetsUpdateKt.Dsl._create(this.toBuilder()).apply { block() }._build()

