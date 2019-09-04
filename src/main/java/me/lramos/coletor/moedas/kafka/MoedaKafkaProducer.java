package me.lramos.coletor.moedas.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import me.lramos.coletor.moedas.dto.MoedaDTO;

/**
 * @author leonardo
 *
 */
@Component
public class MoedaKafkaProducer {

	@Autowired
	private KafkaTemplate<String, MoedaDTO> kafkaTemplate;

	public void sendMessages(List<MoedaDTO> moedas) {

		moedas.forEach(moeda -> {

			ListenableFuture<SendResult<String, MoedaDTO>> future = kafkaTemplate.send("moedas", moeda);

			future.addCallback(new ListenableFutureCallback<SendResult<String, MoedaDTO>>() {

				@Override
				public void onSuccess(SendResult<String, MoedaDTO> result) {
					System.out.println(
							"Sent message=[" + moeda + "] with offset=[" + result.getRecordMetadata().offset() + "]");
				}

				@Override
				public void onFailure(Throwable ex) {
					System.out.println(
							"Unable to send message=[" + moeda + "] due to : " + ex.getMessage());
				}

			});

		});
		
	}

}
