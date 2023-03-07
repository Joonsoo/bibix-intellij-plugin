package com.giyeok.bibix.intellijplugin.rpc

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

object ChannelsManager {
  private val _channel = ManagedChannelBuilder.forAddress("localhost", 8088).build()

  fun getChannel(): ManagedChannel = _channel
}
