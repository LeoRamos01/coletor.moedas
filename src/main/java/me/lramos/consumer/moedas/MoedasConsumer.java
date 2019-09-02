package me.lramos.consumer.moedas;

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

	public void consume() {

		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "eltabo");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		List<MoedaDTO> moedas = this.exchangeAsList(URL, new ParameterizedTypeReference<List<MoedaDTO>>() {
		}, entity);

		moedas.forEach(System.out::println);

	}

}
