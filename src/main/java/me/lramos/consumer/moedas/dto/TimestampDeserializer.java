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
 * 
 * Custom {@link StdDeserializer} para o campo {@link MoedaDTO#getTimestamp()}.
 * <p>
 * Transformo-o de um timestamp em segundos para um {@link LocalDateTime} de
 * formato: <b>yyyy-MM-dd HH:mm:ss</b>
 * 
 * @author leonardorm
 *
 */
public class TimestampDeserializer extends StdDeserializer<String> {

	private static final long serialVersionUID = -6522318535434568263L;

	public TimestampDeserializer() {

		this(null);
	}

	public TimestampDeserializer(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public String deserialize(JsonParser jasonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		return getFormatted(convertSecondsToMillis(getTimestampAsString(jasonParser)));
	}

	private long convertSecondsToMillis(String timestamp) {
		return Long.parseLong(timestamp) * 1000;
	}

	private String getTimestampAsString(JsonParser jasonParser) throws IOException {
		JsonNode node = jasonParser.getCodec().readTree(jasonParser);
		String timestamp = node.textValue();
		return timestamp;
	}

	private String getFormatted(long timestampMillis) {
		LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampMillis),
				TimeZone.getDefault().toZoneId());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		return date.format(formatter);
	}

}
