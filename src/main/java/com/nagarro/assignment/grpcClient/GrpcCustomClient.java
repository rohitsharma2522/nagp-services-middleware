package com.nagarro.assignment.grpcClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.grpc.Order.OrderRequest;
import com.nagarro.assignment.grpc.Order.OrderResponse;
import com.nagarro.assignment.grpc.Order.OrderUpdateRequest;
import com.nagarro.assignment.grpc.Order.OrderUpdateResponse;
import com.nagarro.assignment.grpc.OrderServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PostConstruct;

@Service
public class GrpcCustomClient {

    private ManagedChannel channel;
    private OrderServiceGrpc.OrderServiceBlockingStub blockingStub;
    @Value("${grpc.server.port}")
    private int port;
    @Value("${grpc.server.host}")
    private String host;
    
    @PostConstruct
    public void init() {
        channel = ManagedChannelBuilder.forAddress(host, port)
                                           .usePlaintext() // Use plaintext communication (without TLS) for simplicity
                                           .build();
        blockingStub = OrderServiceGrpc.newBlockingStub(channel);
    }

    public OrderResponse placeOrder(com.nagarro.assignment.order.OrderHttpRequest request) {
        OrderRequest reqObj = OrderRequest.newBuilder().setColor(request.getColor()).setDescription(request.getDescription())
    						.setPrice(Long.parseLong(request.getPrice())).setProduct(request.getProduct()).setStatus(request.getStatus()).build();
        OrderResponse respObj = blockingStub.placeOrder(reqObj);
        return respObj;
    }
    public OrderUpdateResponse updateOrder(com.nagarro.assignment.order.OrderHttpRequest request) {
        OrderUpdateRequest updateReq = OrderUpdateRequest.newBuilder().setStatus(request.getStatus()).build();
         OrderUpdateResponse updateOrder = blockingStub.updateOrder(updateReq);
        return updateOrder;
    }

    public void shutdown() {
        channel.shutdown();
    }
}