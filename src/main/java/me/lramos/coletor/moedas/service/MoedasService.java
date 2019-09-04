package me.lramos.coletor.moedas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.lramos.coletor.moedas.coletor.ColetorMoedas;
import me.lramos.coletor.moedas.dto.MoedaDTO;
import me.lramos.coletor.moedas.kafka.MoedaKafkaProducer;

/**
 * @author leonardo
 *
 */
@Service
public class MoedasService {

	@Autowired
	ColetorMoedas coletorMoedas;
	
	@Autowired
	MoedaKafkaProducer kafkaProducer;
	
	public List<MoedaDTO> getMoedas() {
		
		List<MoedaDTO> moedas = coletorMoedas.coletar();
		
		kafkaProducer.sendMessages(moedas);
		
		return moedas;
	}
	
}
