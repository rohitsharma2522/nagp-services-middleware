package com.nagarro.assignment.rabbitmq;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.nagarro.assignment.order.OrderHttpRequest;

@Component

public class MessageConsumer {

	
	  @RabbitListener(queues = "notificationQueue1")
	    public void handleMessageFromQueue1(OrderHttpRequest message) {
	        System.out.println("Received message from notificationQueue1: " + message.toString());
	    }

	    @RabbitListener(queues = "notificationQueue2")
	    public void handleMessageFromQueue2(OrderHttpRequest message) {
	        System.out.println("Received message from notificationQueue2: " + message.toString());
	    }
}
