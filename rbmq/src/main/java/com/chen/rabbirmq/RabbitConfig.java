package com.chen.rabbirmq;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostConstruct
	public void initRabbitTemplate() {
		// 设置生产者消息确认
		rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());
	}
	
	@Bean
    public Queue helloQueue(){
		return new Queue("hello");

    }
	
	 @Bean
	    public FanoutExchange confirmExchange() {
	        return new FanoutExchange("confirm_exchange");
	    }
	 @Bean
	    DirectExchange TestDirectExchange() {
	        return new DirectExchange("TestDirectExchange");
	    }
	 
	    //交换器绑定队列
	    @Bean
	    Binding bindingExchangeConfirm(Queue confirmQueue, FanoutExchange confirmExchange) {
	        return BindingBuilder.bind(helloQueue()).to(confirmExchange);
	    }



}
