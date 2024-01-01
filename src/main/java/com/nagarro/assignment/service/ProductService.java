package com.nagarro.assignment.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.nagarro.assignment.grpc.Order.OrderResponse;
import com.nagarro.assignment.grpc.Order.OrderUpdateResponse;
import com.nagarro.assignment.grpcClient.GrpcCustomClient;
import com.nagarro.assignment.order.OrderHttpRequest;
import com.nagarro.assignment.product.ProductRequest;

@Service
public class ProductService {

	@Autowired
	ProductRequest request;

	@Autowired
	GrpcCustomClient grpcCustomClient;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private FanoutExchange fanoutExchange;
	
	@Autowired
	private TopicExchange updateTopicExchange;

	
	private Map<String, OrderHttpRequest> hm = new HashMap<>();
	
	AtomicInteger i = new AtomicInteger(0);

	public String placeOrder(OrderHttpRequest req) throws Exception {
		String resp = StringUtils.EMPTY;
		if(CollectionUtils.isNotEmpty(request.getData())) {
			Optional<OrderHttpRequest> findAny = request.getData().stream()
											.filter(x->x.getId().equals(req.getId())).findAny();
			if(findAny.isPresent()) {
				hm.put(req.getId(), req);
				try {
					rabbitTemplate.convertAndSend(fanoutExchange.getName(), "dummy", req);
				}catch(Exception e) {
					System.out.println("error is "+ e);
				}
				OrderResponse responseObj = grpcCustomClient.placeOrder(req);
				resp = convertToJson(responseObj);
			} else {
				resp = "Product does not exist";
			}
			
		}
		return resp;
	}
	public String updateOrder(String id, OrderHttpRequest req) throws Exception {
		String resp = StringUtils.EMPTY;
		Map<String, String> jsonRequest = new HashMap<>();
			if(hm.containsKey(id)){
				hm.get(id).setStatus(req.getStatus());
				jsonRequest.put("id", hm.get(id).getId());
				jsonRequest.put("status", hm.get(id).getStatus());
				try {
					rabbitTemplate.convertAndSend(updateTopicExchange.getName(), "*", jsonRequest);
				}catch(Exception e) {
					System.out.println("error is "+ e);
				}
				OrderUpdateResponse responseObj = grpcCustomClient.updateOrder(hm.get(id));
				resp = convertToJson(responseObj);
			} else {
				resp = "Product does not exist";
			}
			
		return resp;
	}

	private <T> String convertToJson(T grpcResponse) throws Exception {
		JsonFormat.Printer printer = JsonFormat.printer().preservingProtoFieldNames();
		String json = printer.print((MessageOrBuilder) grpcResponse);
		return json;
	}

}
