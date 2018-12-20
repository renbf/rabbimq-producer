package com.yl.mq;

public interface MqProducer {

	/**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
    
}
