package com.nagarro.assignment.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

	String firstQueue = "notificationQueue1";
	String secondQueue = "notificationQueue2";
	String updateTopicExchange = "updateExchange";
	
	@Bean
	public Queue firstQueue() {
		return new Queue(firstQueue);
	}
	@Bean
	public Queue secondQueue() {
		return new Queue(secondQueue);
	}
	@Bean
    TopicExchange topicExchange() {
        return new TopicExchange(updateTopicExchange);
    }
	@Bean
    FanoutExchange exchange() {
        return new FanoutExchange("fanout-exchange");
    }
	 @Bean
    Binding thirdQueueBinding(@Qualifier("secondQueue") Queue secondQueue, TopicExchange exchange) {
        return BindingBuilder.bind(secondQueue).to(exchange).with("*");
    }
 
	@Bean
    Binding firstQueueBinding(@Qualifier("firstQueue") Queue firstQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(firstQueue).to(exchange);
    }
 
    @Bean
    Binding secondQueueBinding(@Qualifier("secondQueue") Queue secondQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(secondQueue).to(exchange);
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setAutomaticRecoveryEnabled(false);

        return factory;
    }
    @Bean
    public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
 
}
