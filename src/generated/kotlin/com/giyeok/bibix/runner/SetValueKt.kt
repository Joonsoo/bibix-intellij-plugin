//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: values.proto

package com.giyeok.bibix.runner;

@kotlin.jvm.JvmSynthetic
public inline fun setValue(block: com.giyeok.bibix.runner.SetValueKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.runner.BibixValueProto.SetValue =
  com.giyeok.bibix.runner.SetValueKt.Dsl._create(com.giyeok.bibix.runner.BibixValueProto.SetValue.newBuilder()).apply { block() }._build()
public object SetValueKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.runner.BibixValueProto.SetValue.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.runner.BibixValueProto.SetValue.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.runner.BibixValueProto.SetValue = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class ValuesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     */
     public val values: com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getValuesList()
      )
    /**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     * @param value The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addValues")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.add(value: com.giyeok.bibix.runner.BibixValueProto.BibixValue) {
      _builder.addValues(value)
    }/**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     * @param value The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignValues")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.plusAssign(value: com.giyeok.bibix.runner.BibixValueProto.BibixValue) {
      add(value)
    }/**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     * @param values The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllValues")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.addAll(values: kotlin.collections.Iterable<com.giyeok.bibix.runner.BibixValueProto.BibixValue>) {
      _builder.addAllValues(values)
    }/**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     * @param values The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllValues")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.plusAssign(values: kotlin.collections.Iterable<com.giyeok.bibix.runner.BibixValueProto.BibixValue>) {
      addAll(values)
    }/**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     * @param index The index to set the value at.
     * @param value The values to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setValues")
    public operator fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.set(index: kotlin.Int, value: com.giyeok.bibix.runner.BibixValueProto.BibixValue) {
      _builder.setValues(index, value)
    }/**
     * <code>repeated .com.giyeok.bibix.runner.BibixValue values = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearValues")
    public fun com.google.protobuf.kotlin.DslList<com.giyeok.bibix.runner.BibixValueProto.BibixValue, ValuesProxy>.clear() {
      _builder.clearValues()
    }}
}
@kotlin.jvm.JvmSynthetic
public inline fun com.giyeok.bibix.runner.BibixValueProto.SetValue.copy(block: com.giyeok.bibix.runner.SetValueKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.runner.BibixValueProto.SetValue =
  com.giyeok.bibix.runner.SetValueKt.Dsl._create(this.toBuilder()).apply { block() }._build()
