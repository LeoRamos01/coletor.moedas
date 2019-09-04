package me.lramos.consumer.moedas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.lramos.consumer.moedas.coletor.ColetorMoedas;
import me.lramos.consumer.moedas.dto.MoedaDTO;
import me.lramos.consumer.moedas.kafka.MoedaKafkaProducer;

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
