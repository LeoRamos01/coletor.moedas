package me.lramos.coletor.moedas.json;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.lramos.coletor.moedas.json.TimestampDeserializer;

/**
 * Teste para {@link TimestampDeserializer}.
 * 
 * @author leonardo
 *
 */
public class TimestampDeserializerTest {

	ObjectMapper objectMapper;
	TimestampDeserializer timestampDeserializer;

	@Before
	public void setUp() {

		objectMapper = new ObjectMapper();
		timestampDeserializer = new TimestampDeserializer();

	}

	/**
	 * <li><b>Timestamp: </b>1567434698</li>
	 * <li><b>Data: </b>02/09/2019 11:31:38</li>
	 * <li><b>Formato: </b>yyyy-MM-dd HH:mm:ss</li>
	 * 
	 * @throws JsonParseException
	 * @throws IOException
	 */
	@Test
	public void testDeserialize() throws JsonParseException, IOException {

		ByteArrayInputStream byteArrayInputStream = 
				new ByteArrayInputStream("\"1567434698\"".getBytes(StandardCharsets.UTF_8));
		
		JsonParser jasonParser = objectMapper.getFactory().createParser(byteArrayInputStream);
		
		DeserializationContext context = objectMapper.getDeserializationContext();

		String actual = timestampDeserializer.deserialize(jasonParser, context);

		assertEquals("2019-09-02 11:31:38", actual);
	}

}
