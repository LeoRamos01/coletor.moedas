package me.lramos.coletor.moedas.coletor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import me.lramos.coletor.moedas.coletor.ColetorMoedas;
import me.lramos.coletor.moedas.dto.MoedaDTO;

/**
 * 
 * Teste para {@link ColetorMoedas}.
 * 
 * @author leonardo
 *
 */
public class ColetorMoedasTest {

	@InjectMocks
	ColetorMoedas coletorMoedas;

	@Mock
	RestTemplate restTemplate;

	@Before
	public void setUp() {

		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "eltabo");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		MockitoAnnotations.initMocks(this);

		// Primeira: tudo preenchido
		MoedaDTO first = new MoedaDTO();

		first.setAlta(new BigDecimal("4.19"));
		first.setBaixa(new BigDecimal("4.12"));
		first.setCodigo("USD");
		first.setCodigoDestino("BRL");
		first.setCompra(new BigDecimal("4.172"));
		first.setData("2019-09-02 11:28:36");
		first.setNome("Dólar");
		first.setPorcentagemDeVariacao(new BigDecimal("0.05"));
		first.setTimestamp("2019-09-02 11:28:36");
		first.setVariacao(new BigDecimal("0.01"));
		first.setVenda(new BigDecimal("4.181"));

		// Da segunda em diante alguns campos vêm null:
		MoedaDTO second = new MoedaDTO();

		second.setAlta(new BigDecimal("4.19"));
		second.setBaixa(new BigDecimal("4.12"));
		second.setCodigo(null);
		second.setCodigoDestino(null);
		second.setCompra(new BigDecimal("4.172"));
		second.setData(null);
		second.setNome(null);
		second.setPorcentagemDeVariacao(new BigDecimal("0.05"));
		second.setTimestamp("2019-09-02 11:28:36");
		second.setVariacao(new BigDecimal("0.01"));
		second.setVenda(new BigDecimal("4.181"));

		ResponseEntity<List<MoedaDTO>> value = new ResponseEntity<List<MoedaDTO>>(Arrays.asList(first, second),
				HttpStatus.OK);

		Mockito.when(restTemplate.exchange(ColetorMoedas.URL, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<MoedaDTO>>() {
				})).thenReturn(value);
	}

	@Test
	public void consumeTest() {

		MoedaDTO first = new MoedaDTO();

		first.setAlta(new BigDecimal("4.19"));
		first.setBaixa(new BigDecimal("4.12"));
		first.setCodigo("USD");
		first.setCodigoDestino("BRL");
		first.setCompra(new BigDecimal("4.172"));
		first.setData("2019-09-02 11:28:36");
		first.setNome("Dólar");
		first.setPorcentagemDeVariacao(new BigDecimal("0.05"));
		first.setTimestamp("2019-09-02 11:28:36");
		first.setVariacao(new BigDecimal("0.01"));
		first.setVenda(new BigDecimal("4.181"));

		MoedaDTO second = new MoedaDTO();

		second.setAlta(new BigDecimal("4.19"));
		second.setBaixa(new BigDecimal("4.12"));
		second.setCodigo("USD");
		second.setCodigoDestino("BRL");
		second.setCompra(new BigDecimal("4.172"));
		second.setData("2019-09-02 11:28:36");
		second.setNome("Dólar");
		second.setPorcentagemDeVariacao(new BigDecimal("0.05"));
		second.setTimestamp("2019-09-02 11:28:36");
		second.setVariacao(new BigDecimal("0.01"));
		second.setVenda(new BigDecimal("4.181"));

		List<MoedaDTO> expected = coletorMoedas.coletar();

		assertEquals(expected, Arrays.asList(first, second));
	}

}
