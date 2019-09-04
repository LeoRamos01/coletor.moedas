package me.lramos.consumer.moedas.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.lramos.consumer.moedas.coletor.ColetorMoedas;
import me.lramos.consumer.moedas.json.TimestampDeserializer;

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
 * Isso é tratado no {@link ColetorMoedas}.
 * 
 * @author leonardorm
 *
 */
@Data
public class MoedaDTO {

	@Setter(onMethod_ = { @JsonSetter("code") })
	@Getter(onMethod_ = { @JsonGetter("codigo") })
	private String codigo;

	@Setter(onMethod_ = { @JsonSetter("codein") })
	@Getter(onMethod_ = { @JsonGetter("codigoDestino") })
	private String codigoDestino;

	@Setter(onMethod_ = { @JsonSetter("name") })
	@Getter(onMethod_ = { @JsonGetter("nome") })
	private String nome;

	@Setter(onMethod_ = { @JsonSetter("high") })
	@Getter(onMethod_ = { @JsonGetter("alta") })
	private BigDecimal alta;

	@Setter(onMethod_ = { @JsonSetter("low") })
	@Getter(onMethod_ = { @JsonGetter("baixa") })
	private BigDecimal baixa;

	@Setter(onMethod_ = { @JsonSetter("varBid") })
	@Getter(onMethod_ = { @JsonGetter("variacao") })
	private BigDecimal variacao;

	@Setter(onMethod_ = { @JsonSetter("pctChange") })
	@Getter(onMethod_ = { @JsonGetter("porcentagemDeVariacao") })
	private BigDecimal porcentagemDeVariacao;

	@Setter(onMethod_ = { @JsonSetter("bid") })
	@Getter(onMethod_ = { @JsonGetter("compra") })
	private BigDecimal compra;

	@Setter(onMethod_ = { @JsonSetter("ask") })
	@Getter(onMethod_ = { @JsonGetter("venda") })
	private BigDecimal venda;

	@JsonProperty
	@JsonDeserialize(using = TimestampDeserializer.class)
	@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
	private String timestamp;

	@Setter(onMethod_ = { @JsonSetter("create_date") })
	@Getter(onMethod_ = { @JsonGetter("dataConsulta") })
	private String data;

}
