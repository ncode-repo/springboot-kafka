package org.nil.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static final String TOPIC = "users";
	
	@Autowired 
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String message) {
		this.kafkaTemplate.send(TOPIC, message);
	}

}
