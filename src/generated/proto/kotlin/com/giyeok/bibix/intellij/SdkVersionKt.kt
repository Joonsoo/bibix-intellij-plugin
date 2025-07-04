// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmName("-initializesdkVersion")
public inline fun sdkVersion(block: com.giyeok.bibix.intellij.SdkVersionKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion =
  com.giyeok.bibix.intellij.SdkVersionKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `com.giyeok.bibix.intellij.SdkVersion`
 */
public object SdkVersionKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion = _builder.build()

    /**
     * `string jdk_version = 1;`
     */
    public var jdkVersion: kotlin.String
      @JvmName("getJdkVersion")
      get() = _builder.getJdkVersion()
      @JvmName("setJdkVersion")
      set(value) {
        _builder.setJdkVersion(value)
      }
    /**
     * `string jdk_version = 1;`
     */
    public fun clearJdkVersion() {
      _builder.clearJdkVersion()
    }
    /**
     * `string jdk_version = 1;`
     * @return Whether the jdkVersion field is set.
     */
    public fun hasJdkVersion(): kotlin.Boolean {
      return _builder.hasJdkVersion()
    }

    /**
     * `string ktjvm_sdk_version = 2;`
     */
    public var ktjvmSdkVersion: kotlin.String
      @JvmName("getKtjvmSdkVersion")
      get() = _builder.getKtjvmSdkVersion()
      @JvmName("setKtjvmSdkVersion")
      set(value) {
        _builder.setKtjvmSdkVersion(value)
      }
    /**
     * `string ktjvm_sdk_version = 2;`
     */
    public fun clearKtjvmSdkVersion() {
      _builder.clearKtjvmSdkVersion()
    }
    /**
     * `string ktjvm_sdk_version = 2;`
     * @return Whether the ktjvmSdkVersion field is set.
     */
    public fun hasKtjvmSdkVersion(): kotlin.Boolean {
      return _builder.hasKtjvmSdkVersion()
    }

    /**
     * `string scala_sdk_version = 3;`
     */
    public var scalaSdkVersion: kotlin.String
      @JvmName("getScalaSdkVersion")
      get() = _builder.getScalaSdkVersion()
      @JvmName("setScalaSdkVersion")
      set(value) {
        _builder.setScalaSdkVersion(value)
      }
    /**
     * `string scala_sdk_version = 3;`
     */
    public fun clearScalaSdkVersion() {
      _builder.clearScalaSdkVersion()
    }
    /**
     * `string scala_sdk_version = 3;`
     * @return Whether the scalaSdkVersion field is set.
     */
    public fun hasScalaSdkVersion(): kotlin.Boolean {
      return _builder.hasScalaSdkVersion()
    }
    public val sdkCase: com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion.SdkCase
      @JvmName("getSdkCase")
      get() = _builder.getSdkCase()

    public fun clearSdk() {
      _builder.clearSdk()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion.copy(block: `com.giyeok.bibix.intellij`.SdkVersionKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.SdkVersion =
  `com.giyeok.bibix.intellij`.SdkVersionKt.Dsl._create(this.toBuilder()).apply { block() }._build()

