//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api.proto

package com.giyeok.bibix.intellij;

@kotlin.jvm.JvmSynthetic
public inline fun moduleSdk(block: com.giyeok.bibix.intellij.ModuleSdkKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk =
  com.giyeok.bibix.intellij.ModuleSdkKt.Dsl._create(com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk.newBuilder()).apply { block() }._build()
public object ModuleSdkKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk = _builder.build()

    /**
     * <code>string jdk_version = 1;</code>
     */
    public var jdkVersion: kotlin.String
      @JvmName("getJdkVersion")
      get() = _builder.getJdkVersion()
      @JvmName("setJdkVersion")
      set(value) {
        _builder.setJdkVersion(value)
      }
    /**
     * <code>string jdk_version = 1;</code>
     */
    public fun clearJdkVersion() {
      _builder.clearJdkVersion()
    }
    /**
     * <code>string jdk_version = 1;</code>
     * @return Whether the jdkVersion field is set.
     */
    public fun hasJdkVersion(): kotlin.Boolean {
      return _builder.hasJdkVersion()
    }

    /**
     * <code>string ktjvm_sdk_version = 2;</code>
     */
    public var ktjvmSdkVersion: kotlin.String
      @JvmName("getKtjvmSdkVersion")
      get() = _builder.getKtjvmSdkVersion()
      @JvmName("setKtjvmSdkVersion")
      set(value) {
        _builder.setKtjvmSdkVersion(value)
      }
    /**
     * <code>string ktjvm_sdk_version = 2;</code>
     */
    public fun clearKtjvmSdkVersion() {
      _builder.clearKtjvmSdkVersion()
    }
    /**
     * <code>string ktjvm_sdk_version = 2;</code>
     * @return Whether the ktjvmSdkVersion field is set.
     */
    public fun hasKtjvmSdkVersion(): kotlin.Boolean {
      return _builder.hasKtjvmSdkVersion()
    }

    /**
     * <code>string scala_sdk_version = 3;</code>
     */
    public var scalaSdkVersion: kotlin.String
      @JvmName("getScalaSdkVersion")
      get() = _builder.getScalaSdkVersion()
      @JvmName("setScalaSdkVersion")
      set(value) {
        _builder.setScalaSdkVersion(value)
      }
    /**
     * <code>string scala_sdk_version = 3;</code>
     */
    public fun clearScalaSdkVersion() {
      _builder.clearScalaSdkVersion()
    }
    /**
     * <code>string scala_sdk_version = 3;</code>
     * @return Whether the scalaSdkVersion field is set.
     */
    public fun hasScalaSdkVersion(): kotlin.Boolean {
      return _builder.hasScalaSdkVersion()
    }
    public val sdkCase: com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk.SdkCase
      @JvmName("getSdkCase")
      get() = _builder.getSdkCase()

    public fun clearSdk() {
      _builder.clearSdk()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk.copy(block: com.giyeok.bibix.intellij.ModuleSdkKt.Dsl.() -> kotlin.Unit): com.giyeok.bibix.intellij.BibixIntellijProto.ModuleSdk =
  com.giyeok.bibix.intellij.ModuleSdkKt.Dsl._create(this.toBuilder()).apply { block() }._build()