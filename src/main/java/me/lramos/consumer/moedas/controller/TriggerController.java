package me.lramos.consumer.moedas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.lramos.consumer.moedas.consumers.MoedasConsumer;
import me.lramos.consumer.moedas.dto.MoedaDTO;

/**
 * @author leonardorm
 *
 */
@RestController("")
public class TriggerController {

	@Autowired
	MoedasConsumer consumer;
	
	@GetMapping("/vai")
	public List<MoedaDTO> chamaAi() {
		return consumer.consume();
	}
	
}
