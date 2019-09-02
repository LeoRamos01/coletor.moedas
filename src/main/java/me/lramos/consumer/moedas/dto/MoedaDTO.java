package me.lramos.consumer.moedas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import me.lramos.consumer.moedas.consumers.MoedasConsumer;

/**
 * Exemplo:
 * 
 * <pre>
 *    {  
      "code":"USD",
      "codein":"BRL",
      "name":"Dólar Comercial",
      "high":"4.1711",
      "low":"4.1212",
      "varBid":"-0.0232",
      "pctChange":"-0.56",
      "bid":"4.1444",
      "ask":"4.1461",
      "timestamp":"1567198798",
      "create_date":"2019-08-30 21:00:02"
   },
   {  
      "high":"4.1711",
      "low":"4.1212",
      "varBid":"-0.0226",
      "pctChange":"-0.54",
      "bid":"4.1455",
      "ask":"4.1462",
      "timestamp":"1567198744"
   },
 * 
 * </pre>
 * 
 * <b>Observação:</b> A primeira moeda tem alguns dados que as demais não tem.
 * Isso é tratado no {@link MoedasConsumer}.
 * 
 * @author leonardorm
 *
 */
@Data
public class MoedaDTO {

	@JsonProperty("code")
	private String codigo;

	@JsonProperty("codein")
	private String codigoDestino;

	@JsonProperty("name")
	private String nome;

	@JsonProperty("high")
	private String alta;

	@JsonProperty("low")
	private String baixa;

	@JsonProperty("varBid")
	private String variacao;

	@JsonProperty("pctChange")
	private String porcentagemDeVariacao;

	@JsonProperty("bid")
	private String compra;

	@JsonProperty("ask")
	private String venda;

	@JsonProperty("timestamp")
	@JsonDeserialize(using = TimestampDeserializer.class)
	@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
	private String timestamp;

	@JsonProperty("create_date")
	private String data;

}
