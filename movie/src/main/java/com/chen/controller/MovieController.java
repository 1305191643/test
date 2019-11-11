package com.chen.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chen.entry.User;
import com.chen.fegin.PromotionClient;
import com.chen.rabbitmqutil.ConnectionUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

@RestController
public class MovieController {
	
	
	@Autowired
	public RestTemplate restTemplate;
	
	 @Autowired
	PromotionClient promotionClient;
	
	
	
	/*@RequestMapping(value = "/movie")
	public  List<User> getUsers(){
		return   restTemplate.getForObject("http://localhost:8081/user", List.class);
	}*/
	
	
	@RequestMapping(value = "/movie")
	public  List<User> getUsers(@RequestParam("name") String name){
	/*	// 获取到连接以及mq通道
        Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			  // 从连接中创建通道
	        Channel channel = connection.createChannel();

	        // 声明（创建）队列
	        channel.queueDeclare("q_test_01", false, false, false, null);

	        // 消息内容
	        String message = "Hello World!";
	        channel.basicPublish("", "q_test_01", null, message.getBytes());
	        System.out.println(" [x] Sent '" + message + "'");
	        //关闭通道和连接
	        channel.close();
	        connection.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(name+"1111111111111111111111111111111111111111");
		return   promotionClient.releasePromotion(name);
	}
	
	
	@RequestMapping(value = "/insert")
	public void insert(String name){
		User user=new User();
		user.setName(name);
		promotionClient.insert(user);
	}
	 
}
