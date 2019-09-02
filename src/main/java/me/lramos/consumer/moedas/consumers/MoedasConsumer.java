package me.lramos.consumer.moedas.consumers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	/**
	 * 
	 * Coleto as moedas numa unmodifiableList para evitar bugs. Trato-as a seguir no {@link #replicar(List)}.
	 * 
	 * @return
	 */
	public List<MoedaDTO> consume() {

		final HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "eltabo");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		List<MoedaDTO> moedas = 
				Collections
					.unmodifiableList(
						this.exchangeAsList(URL, new ParameterizedTypeReference<List<MoedaDTO>>() {
						}, entity));

		return replicar(moedas);

	}

	/**
	 * 
	 * A primeira moeda recebida tem os seguintes campos que as demais não tem:
	 * 
	 * <li>code</li>
	 * <li>codein</li>
	 * <li>name</li>
	 * <li>create_date</li>
	 * <p>
	 * Para corrigir isso pego tais valores da primeira e copio para as demais.
	 * 
	 * @param moedas
	 * @return 
	 */
	private List<MoedaDTO> replicar(List<MoedaDTO> moedas) {
		
		List<MoedaDTO> listaModificada = new ArrayList<>();

		MoedaDTO first = moedas.get(0);
		
		moedas.forEach(m -> {
			
			MoedaDTO novaMoeda = new MoedaDTO();
			
			BeanUtils.copyProperties(m, novaMoeda);

			novaMoeda.setCodigo(first.getCodigo());
			novaMoeda.setCodigoDestino(first.getCodigoDestino());
			novaMoeda.setNome(first.getNome());
			novaMoeda.setData(first.getData());
			
			listaModificada.add(novaMoeda);

		});
		
		return listaModificada;

	}

}
