package com.yl.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yl.mq.MqProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml"})
public class MqProducerTest{
	@Autowired
	private MqProducer mqProducer;
	
	
	@Test
	public void test() {
        mqProducer.sendDataToQueue("hello", "hello,rabbmitmq!");
	}
	
}
