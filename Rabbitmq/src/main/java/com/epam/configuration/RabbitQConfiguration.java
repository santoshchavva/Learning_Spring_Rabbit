package com.epam.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitQConfiguration {

	@Bean(name ="TestQueue")
	public Queue newQueue() {
		return new Queue("TestQueue");
	}
	
	@Bean(name = "TestBinding")
	public Binding newBinding() {
		final Map<String, String> map = new HashMap<String, String>();
		
		return null ;
	}
	
}
