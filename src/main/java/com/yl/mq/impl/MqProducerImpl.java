package com.yl.mq.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yl.mq.MqProducer;
import com.yl.utils.CreateCode;

@Service("mqProducer")
public class MqProducerImpl implements MqProducer {

	private static final Logger log = LoggerFactory.getLogger(CreateCode.class);
	@Autowired
    private AmqpTemplate amqpTemplate;
	
	@Override
	public void sendDataToQueue(String queueKey, Object object) {
		try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
        	log.error("发送消息失败",e);
        }
	}

}
