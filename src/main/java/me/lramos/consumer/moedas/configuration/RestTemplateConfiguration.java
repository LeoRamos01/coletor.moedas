package me.lramos.consumer.moedas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author leonardorm
 *
 */
@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
