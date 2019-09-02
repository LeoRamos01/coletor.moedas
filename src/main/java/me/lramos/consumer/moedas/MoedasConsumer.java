package me.lramos.consumer.moedas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MoedasConsumer {

	private static final String URL = "https://economia.awesomeapi.com.br/json/list/USD-BRL/";

	@Autowired
	RestTemplate restTemplate;

	public void consume() {

		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "eltabo");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		List<Moeda> moedas = this.exchangeAsList(URL, new ParameterizedTypeReference<List<Moeda>>() {
		}, entity);

		System.out.println(moedas);

	}

	public <T> List<T> exchangeAsList(String uri, ParameterizedTypeReference<List<T>> responseType,
			HttpEntity<String> entity) {
		return restTemplate.exchange(uri, HttpMethod.GET, entity, responseType).getBody();
	}

}
