package com.giyeok.bibix.intellij;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.73.0)",
    comments = "Source: api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BibixIntellijServiceGrpc {

  private BibixIntellijServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.giyeok.bibix.intellij.BibixIntellijService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> getLoadProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "loadProject",
      requestType = com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq.class,
      responseType = com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> getLoadProjectMethod() {
    io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq, com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> getLoadProjectMethod;
    if ((getLoadProjectMethod = BibixIntellijServiceGrpc.getLoadProjectMethod) == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        if ((getLoadProjectMethod = BibixIntellijServiceGrpc.getLoadProjectMethod) == null) {
          BibixIntellijServiceGrpc.getLoadProjectMethod = getLoadProjectMethod =
              io.grpc.MethodDescriptor.<com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq, com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "loadProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo.getDefaultInstance()))
              .setSchemaDescriptor(new BibixIntellijServiceMethodDescriptorSupplier("loadProject"))
              .build();
        }
      }
    }
    return getLoadProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> getBuildTargetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buildTargets",
      requestType = com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.class,
      responseType = com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> getBuildTargetsMethod() {
    io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> getBuildTargetsMethod;
    if ((getBuildTargetsMethod = BibixIntellijServiceGrpc.getBuildTargetsMethod) == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        if ((getBuildTargetsMethod = BibixIntellijServiceGrpc.getBuildTargetsMethod) == null) {
          BibixIntellijServiceGrpc.getBuildTargetsMethod = getBuildTargetsMethod =
              io.grpc.MethodDescriptor.<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "buildTargets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes.getDefaultInstance()))
              .setSchemaDescriptor(new BibixIntellijServiceMethodDescriptorSupplier("buildTargets"))
              .build();
        }
      }
    }
    return getBuildTargetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> getBuildTargetsStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "buildTargetsStreaming",
      requestType = com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.class,
      responseType = com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> getBuildTargetsStreamingMethod() {
    io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> getBuildTargetsStreamingMethod;
    if ((getBuildTargetsStreamingMethod = BibixIntellijServiceGrpc.getBuildTargetsStreamingMethod) == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        if ((getBuildTargetsStreamingMethod = BibixIntellijServiceGrpc.getBuildTargetsStreamingMethod) == null) {
          BibixIntellijServiceGrpc.getBuildTargetsStreamingMethod = getBuildTargetsStreamingMethod =
              io.grpc.MethodDescriptor.<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "buildTargetsStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new BibixIntellijServiceMethodDescriptorSupplier("buildTargetsStreaming"))
              .build();
        }
      }
    }
    return getBuildTargetsStreamingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> getExecuteActionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "executeActions",
      requestType = com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq.class,
      responseType = com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> getExecuteActionsMethod() {
    io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq, com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> getExecuteActionsMethod;
    if ((getExecuteActionsMethod = BibixIntellijServiceGrpc.getExecuteActionsMethod) == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        if ((getExecuteActionsMethod = BibixIntellijServiceGrpc.getExecuteActionsMethod) == null) {
          BibixIntellijServiceGrpc.getExecuteActionsMethod = getExecuteActionsMethod =
              io.grpc.MethodDescriptor.<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq, com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "executeActions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes.getDefaultInstance()))
              .setSchemaDescriptor(new BibixIntellijServiceMethodDescriptorSupplier("executeActions"))
              .build();
        }
      }
    }
    return getExecuteActionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> getExecuteActionsStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "executeActionsStreaming",
      requestType = com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.class,
      responseType = com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
      com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> getExecuteActionsStreamingMethod() {
    io.grpc.MethodDescriptor<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> getExecuteActionsStreamingMethod;
    if ((getExecuteActionsStreamingMethod = BibixIntellijServiceGrpc.getExecuteActionsStreamingMethod) == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        if ((getExecuteActionsStreamingMethod = BibixIntellijServiceGrpc.getExecuteActionsStreamingMethod) == null) {
          BibixIntellijServiceGrpc.getExecuteActionsStreamingMethod = getExecuteActionsStreamingMethod =
              io.grpc.MethodDescriptor.<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq, com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "executeActionsStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new BibixIntellijServiceMethodDescriptorSupplier("executeActionsStreaming"))
              .build();
        }
      }
    }
    return getExecuteActionsStreamingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BibixIntellijServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceStub>() {
        @java.lang.Override
        public BibixIntellijServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BibixIntellijServiceStub(channel, callOptions);
        }
      };
    return BibixIntellijServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static BibixIntellijServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceBlockingV2Stub>() {
        @java.lang.Override
        public BibixIntellijServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BibixIntellijServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return BibixIntellijServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BibixIntellijServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceBlockingStub>() {
        @java.lang.Override
        public BibixIntellijServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BibixIntellijServiceBlockingStub(channel, callOptions);
        }
      };
    return BibixIntellijServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BibixIntellijServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BibixIntellijServiceFutureStub>() {
        @java.lang.Override
        public BibixIntellijServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BibixIntellijServiceFutureStub(channel, callOptions);
        }
      };
    return BibixIntellijServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void loadProject(com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoadProjectMethod(), responseObserver);
    }

    /**
     */
    default void buildTargets(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBuildTargetsMethod(), responseObserver);
    }

    /**
     */
    default void buildTargetsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBuildTargetsStreamingMethod(), responseObserver);
    }

    /**
     */
    default void executeActions(com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteActionsMethod(), responseObserver);
    }

    /**
     */
    default void executeActionsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteActionsStreamingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BibixIntellijService.
   */
  public static abstract class BibixIntellijServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BibixIntellijServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BibixIntellijService.
   */
  public static final class BibixIntellijServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BibixIntellijServiceStub> {
    private BibixIntellijServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BibixIntellijServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BibixIntellijServiceStub(channel, callOptions);
    }

    /**
     */
    public void loadProject(com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoadProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buildTargets(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBuildTargetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void buildTargetsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBuildTargetsStreamingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void executeActions(com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteActionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void executeActionsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request,
        io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getExecuteActionsStreamingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BibixIntellijService.
   */
  public static final class BibixIntellijServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BibixIntellijServiceBlockingV2Stub> {
    private BibixIntellijServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BibixIntellijServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BibixIntellijServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo loadProject(com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadProjectMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes buildTargets(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBuildTargetsMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate>
        buildTargetsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getBuildTargetsStreamingMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes executeActions(com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteActionsMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate>
        executeActionsStreaming(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getExecuteActionsStreamingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BibixIntellijService.
   */
  public static final class BibixIntellijServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BibixIntellijServiceBlockingStub> {
    private BibixIntellijServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BibixIntellijServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BibixIntellijServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo loadProject(com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoadProjectMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes buildTargets(com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBuildTargetsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate> buildTargetsStreaming(
        com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBuildTargetsStreamingMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes executeActions(com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteActionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate> executeActionsStreaming(
        com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getExecuteActionsStreamingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BibixIntellijService.
   */
  public static final class BibixIntellijServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BibixIntellijServiceFutureStub> {
    private BibixIntellijServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BibixIntellijServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BibixIntellijServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo> loadProject(
        com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoadProjectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes> buildTargets(
        com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBuildTargetsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes> executeActions(
        com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteActionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOAD_PROJECT = 0;
  private static final int METHODID_BUILD_TARGETS = 1;
  private static final int METHODID_BUILD_TARGETS_STREAMING = 2;
  private static final int METHODID_EXECUTE_ACTIONS = 3;
  private static final int METHODID_EXECUTE_ACTIONS_STREAMING = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOAD_PROJECT:
          serviceImpl.loadProject((com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq) request,
              (io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo>) responseObserver);
          break;
        case METHODID_BUILD_TARGETS:
          serviceImpl.buildTargets((com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq) request,
              (io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes>) responseObserver);
          break;
        case METHODID_BUILD_TARGETS_STREAMING:
          serviceImpl.buildTargetsStreaming((com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq) request,
              (io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate>) responseObserver);
          break;
        case METHODID_EXECUTE_ACTIONS:
          serviceImpl.executeActions((com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq) request,
              (io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes>) responseObserver);
          break;
        case METHODID_EXECUTE_ACTIONS_STREAMING:
          serviceImpl.executeActionsStreaming((com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq) request,
              (io.grpc.stub.StreamObserver<com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getLoadProjectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.giyeok.bibix.intellij.BibixIntellijProto.LoadProjectReq,
              com.giyeok.bibix.intellij.BibixIntellijProto.BibixProjectInfo>(
                service, METHODID_LOAD_PROJECT)))
        .addMethod(
          getBuildTargetsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
              com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsRes>(
                service, METHODID_BUILD_TARGETS)))
        .addMethod(
          getBuildTargetsStreamingMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
              com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsUpdate>(
                service, METHODID_BUILD_TARGETS_STREAMING)))
        .addMethod(
          getExecuteActionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsReq,
              com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionsRes>(
                service, METHODID_EXECUTE_ACTIONS)))
        .addMethod(
          getExecuteActionsStreamingMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.giyeok.bibix.intellij.BibixIntellijProto.BuildTargetsReq,
              com.giyeok.bibix.intellij.BibixIntellijProto.ExecuteActionUpdate>(
                service, METHODID_EXECUTE_ACTIONS_STREAMING)))
        .build();
  }

  private static abstract class BibixIntellijServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BibixIntellijServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.giyeok.bibix.intellij.BibixIntellijProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BibixIntellijService");
    }
  }

  private static final class BibixIntellijServiceFileDescriptorSupplier
      extends BibixIntellijServiceBaseDescriptorSupplier {
    BibixIntellijServiceFileDescriptorSupplier() {}
  }

  private static final class BibixIntellijServiceMethodDescriptorSupplier
      extends BibixIntellijServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BibixIntellijServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BibixIntellijServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BibixIntellijServiceFileDescriptorSupplier())
              .addMethod(getLoadProjectMethod())
              .addMethod(getBuildTargetsMethod())
              .addMethod(getBuildTargetsStreamingMethod())
              .addMethod(getExecuteActionsMethod())
              .addMethod(getExecuteActionsStreamingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
