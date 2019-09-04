package me.lramos.consumer.moedas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.lramos.consumer.moedas.MoedasService;
import me.lramos.consumer.moedas.dto.MoedaDTO;

/**
 * 
 * Serve apenas para chamar o coletor.
 * 
 * @author leonardorm
 *
 */
@RestController("")
public class TriggerController {

	@Autowired
	MoedasService service;
	
	@GetMapping("/vai")
	public List<MoedaDTO> chamaAi() {
		return service.getMoedas();
	}
	
}
