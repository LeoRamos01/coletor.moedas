package me.lramos.consumer.moedas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.lramos.consumer.moedas.coletor.ColetorMoedas;
import me.lramos.consumer.moedas.dto.MoedaDTO;

/**
 * @author leonardorm
 *
 */
@RestController("")
public class TriggerController {

	@Autowired
	ColetorMoedas coletorMoedas;
	
	@GetMapping("/vai")
	public List<MoedaDTO> chamaAi() {
		return coletorMoedas.coletar();
	}
	
}
