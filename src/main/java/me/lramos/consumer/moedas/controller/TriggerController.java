package me.lramos.consumer.moedas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.lramos.consumer.moedas.MoedasConsumer;

/**
 * @author leonardorm
 *
 */
@RestController("")
public class TriggerController {

	@Autowired
	MoedasConsumer consumer;
	
	@GetMapping("/vai")
	public void chamaAi() {
		consumer.consume();
	}
	
}
