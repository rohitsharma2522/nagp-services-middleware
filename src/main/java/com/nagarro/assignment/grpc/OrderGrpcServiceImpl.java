package com.nagarro.assignment.grpc;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.assignment.grpc.Order.OrderRequest;
import com.nagarro.assignment.grpc.Order.OrderResponse;
import com.nagarro.assignment.grpc.Order.OrderUpdateRequest;
import com.nagarro.assignment.grpc.Order.OrderUpdateResponse;
import com.nagarro.assignment.grpc.OrderServiceGrpc.OrderServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class OrderGrpcServiceImpl extends OrderServiceImplBase {
	
	

	@Override
    public void placeOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
		OrderResponse response = OrderResponse.newBuilder().setMessage("success").setStatusCode(200).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
	@Override
    public void updateOrder(OrderUpdateRequest request, StreamObserver<OrderUpdateResponse> responseObserver) {
		OrderUpdateResponse resp = OrderUpdateResponse.newBuilder().setMessage("Order status changed to "+ request.getStatus()).setStatusCode(200).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
