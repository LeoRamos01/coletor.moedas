package me.lramos.consumer.moedas;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MoedasConsumer {

	private static final String URL = "https://economia.awesomeapi.com.br/json/list/USD-BRL";
	@Autowired
	RestTemplate restTemplate;

	@PostConstruct
	public void afterStartUp() {
		consumer();
	}

	public void consumer() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Moeda> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        Moeda.class);
		
		System.out.println(response);
		
	}

}
