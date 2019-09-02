package me.lramos.consumer.moedas.consumers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import me.lramos.consumer.moedas.dto.MoedaDTO;

/**
 * @author leonardorm
 *
 */
@Component
public class MoedasConsumer extends AbstractConsumer {

	private static final String URL = "https://economia.awesomeapi.com.br/json/list/USD-BRL";

	public List<MoedaDTO> consume() {

		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "eltabo");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		List<MoedaDTO> moedas = this.exchangeAsList(URL, new ParameterizedTypeReference<List<MoedaDTO>>() {
		}, entity);

		replicar(moedas);

		return moedas;

	}

	/**
	 * 
	 * A primeira moeda recebida tem os seguintes campos que as demais não tem:
	 * 
	 * <li>code</li>
	 * <li>codein</li>
	 * <li>name</li>
	 * <li>create_date</li>
	 * 
	 * Para corrigir isso pego a primeira e copio para as demais.
	 * 
	 * @param moedas
	 */
	private void replicar(List<MoedaDTO> moedas) {
		
		MoedaDTO first = moedas.remove(0);

		moedas.forEach(m -> {

			m.setCodigo(first.getCodigo());
			m.setCodigoDestino(first.getCodigoDestino());
			m.setNome(first.getNome());
			m.setData(first.getData());
			
		});

	}

}
