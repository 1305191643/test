package com.chen.rabbirmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;





public class RabbitConfirmCallback implements ConfirmCallback{
	
	private Logger logger = LoggerFactory.getLogger(RabbitConfirmCallback.class);

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info("(start)生产者消息确认=========================");
		logger.info("correlationData:[{}]"+"============"+ correlationData);
		logger.info("ack:[{}]"+"================="+ ack);
		logger.info("cause:[{}]"+"================="+ cause);
		if (!ack) {
			logger.info("消息可能未到达rabbitmq服务器");
		}
		logger.info("(end)生产者消息确认=========================");
	}

}
