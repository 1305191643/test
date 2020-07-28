package com.chen.rabbirmq;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	
    public void send(){
        String msg="hello rabbitMQ:"+new Date()+" 你好，高级消息队列使用ing~";
        Map map=new HashMap();
        map.put("msg", msg);
        map.put("phoneNumber", "18382380421");
        System.out.println("单对单发送参数。Sender发出了消息:"+msg);
        this.rabbitTemplate.convertAndSend("hello",map);
    }


}
