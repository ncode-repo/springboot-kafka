package org.nil.learning.controller;

import javax.websocket.server.PathParam;

import org.nil.learning.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	
	private final Producer producer;
	@Autowired
	public KafkaController(Producer producer) {
		this.producer=producer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@PathParam("message") String message) {
		this.producer.send(message);
	}
}
