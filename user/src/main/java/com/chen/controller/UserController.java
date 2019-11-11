package com.chen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.dao.UserDao;
import com.chen.entry.User;
import com.chen.rabbitmqutil.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.QueueingConsumer;



@RestController
public class UserController {
	
	@Autowired
	public UserDao userDao;
	
	
	@RequestMapping(value = "/user")
    public List<User> getUsers(String name){
		
		System.out.println(name+"nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	/*	List<User> user=null;
		// 获取到连接以及mq通道
        Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			 // 从连接中创建通道
	        Channel channel = connection.createChannel();
	        // 声明队列
	        channel.queueDeclare("q_test_01", false, false, false, null);

	        // 定义队列的消费者
	        QueueingConsumer consumer = new QueueingConsumer(channel);

	        // 监听队列
	        channel.basicConsume("q_test_01", true, consumer);

	        // 获取消息
	        while (true) {
	        	 QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	            String message = new String(delivery.getBody());
	            System.out.println(" [x] Received '" + message + "'");
	            if(message.equals("Hello World!")) {
	            	System.out.println("11111111111111111");
	            	//userDao.getUsers();
	            	userDao.insertUser(u);
	            }

	        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}*/
		User u=new User();
		u.setName(name);
		insertUser(u);
		return userDao.getUsers();
	}
	
	
	@RequestMapping(value = "/insert")
    public void insert(User user){
		 userDao.insertUser(user);
	}
   
   public  void   insertUser(User user) {
	   userDao.insertUser(user);
	   
   }

}
