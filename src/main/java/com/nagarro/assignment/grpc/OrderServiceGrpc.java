package com.nagarro.assignment.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: order.proto")
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderRequest,
      com.nagarro.assignment.grpc.Order.OrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = com.nagarro.assignment.grpc.Order.OrderRequest.class,
      responseType = com.nagarro.assignment.grpc.Order.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderRequest,
      com.nagarro.assignment.grpc.Order.OrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderRequest, com.nagarro.assignment.grpc.Order.OrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = OrderServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getPlaceOrderMethod = OrderServiceGrpc.getPlaceOrderMethod) == null) {
          OrderServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod = 
              io.grpc.MethodDescriptor.<com.nagarro.assignment.grpc.Order.OrderRequest, com.nagarro.assignment.grpc.Order.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OrderService", "PlaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nagarro.assignment.grpc.Order.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nagarro.assignment.grpc.Order.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("PlaceOrder"))
                  .build();
          }
        }
     }
     return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderUpdateRequest,
      com.nagarro.assignment.grpc.Order.OrderUpdateResponse> getUpdateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrder",
      requestType = com.nagarro.assignment.grpc.Order.OrderUpdateRequest.class,
      responseType = com.nagarro.assignment.grpc.Order.OrderUpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderUpdateRequest,
      com.nagarro.assignment.grpc.Order.OrderUpdateResponse> getUpdateOrderMethod() {
    io.grpc.MethodDescriptor<com.nagarro.assignment.grpc.Order.OrderUpdateRequest, com.nagarro.assignment.grpc.Order.OrderUpdateResponse> getUpdateOrderMethod;
    if ((getUpdateOrderMethod = OrderServiceGrpc.getUpdateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getUpdateOrderMethod = OrderServiceGrpc.getUpdateOrderMethod) == null) {
          OrderServiceGrpc.getUpdateOrderMethod = getUpdateOrderMethod = 
              io.grpc.MethodDescriptor.<com.nagarro.assignment.grpc.Order.OrderUpdateRequest, com.nagarro.assignment.grpc.Order.OrderUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OrderService", "UpdateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nagarro.assignment.grpc.Order.OrderUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.nagarro.assignment.grpc.Order.OrderUpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("UpdateOrder"))
                  .build();
          }
        }
     }
     return getUpdateOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    return new OrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void placeOrder(com.nagarro.assignment.grpc.Order.OrderRequest request,
        io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     */
    public void updateOrder(com.nagarro.assignment.grpc.Order.OrderUpdateRequest request,
        io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderUpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlaceOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nagarro.assignment.grpc.Order.OrderRequest,
                com.nagarro.assignment.grpc.Order.OrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .addMethod(
            getUpdateOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.nagarro.assignment.grpc.Order.OrderUpdateRequest,
                com.nagarro.assignment.grpc.Order.OrderUpdateResponse>(
                  this, METHODID_UPDATE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class OrderServiceStub extends io.grpc.stub.AbstractStub<OrderServiceStub> {
    private OrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void placeOrder(com.nagarro.assignment.grpc.Order.OrderRequest request,
        io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateOrder(com.nagarro.assignment.grpc.Order.OrderUpdateRequest request,
        io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderUpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.nagarro.assignment.grpc.Order.OrderResponse placeOrder(com.nagarro.assignment.grpc.Order.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.nagarro.assignment.grpc.Order.OrderUpdateResponse updateOrder(com.nagarro.assignment.grpc.Order.OrderUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nagarro.assignment.grpc.Order.OrderResponse> placeOrder(
        com.nagarro.assignment.grpc.Order.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.nagarro.assignment.grpc.Order.OrderUpdateResponse> updateOrder(
        com.nagarro.assignment.grpc.Order.OrderUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;
  private static final int METHODID_UPDATE_ORDER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((com.nagarro.assignment.grpc.Order.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ORDER:
          serviceImpl.updateOrder((com.nagarro.assignment.grpc.Order.OrderUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.nagarro.assignment.grpc.Order.OrderUpdateResponse>) responseObserver);
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

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.nagarro.assignment.grpc.Order.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .addMethod(getUpdateOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
