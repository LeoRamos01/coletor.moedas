package me.lramos.coletor.moedas.coletor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author leonardorm
 *
 */
public class AbstractColetor {
	
	@Autowired
	RestTemplate restTemplate;
	
	<T> List<T> exchangeAsList(String uri, ParameterizedTypeReference<List<T>> responseType,
			HttpEntity<String> entity) {
		return restTemplate.exchange(uri, HttpMethod.GET, entity, responseType).getBody();
	}

}
