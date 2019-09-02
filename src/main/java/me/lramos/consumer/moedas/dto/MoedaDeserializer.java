package me.lramos.consumer.moedas.dto;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author leonardorm
 *
 */
public class MoedaDeserializer extends StdDeserializer<MoedaDTO> {

	private static final long serialVersionUID = -7771509302128580497L;

	public MoedaDeserializer() {

		this(null);
	}

	public MoedaDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public MoedaDTO deserialize(JsonParser jasonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		JsonNode node = jasonParser.getCodec().readTree(jasonParser);
		String timestamp = node.get("timestamp").textValue();

		long timestampMillis = Long.parseLong(timestamp) * 1000;

		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampMillis),
				TimeZone.getDefault().toZoneId());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		MoedaDTO moeda = new MoedaDTO();
		moeda.setTimestamp(date.format(formatter));

		return moeda;
	}

}
