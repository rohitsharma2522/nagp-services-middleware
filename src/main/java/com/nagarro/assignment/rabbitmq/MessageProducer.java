package com.nagarro.assignment.rabbitmq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.assignment.grpc.Order.OrderRequest;

public class MessageProducer {
//	@Autowired
//    private RabbitTemplate rabbitTemplate;

//    @PostMapping("/send")
//    public String sendMessage(@RequestBody OrderRequest orderRequest) {
////        rabbitTemplate.convertAndSend("fanout-exchange", orderRequest);
//        return "Message sent to RabbitMQ: " + orderRequest;
//    }
}
