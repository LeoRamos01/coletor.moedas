package me.lramos.consumer.moedas.dto;

import lombok.Data;

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
 * @author leonardorm
 *
 */
@Data
public class MoedaDTO {
	
	private String code;

	private String codein;

	private String name;

	private String high;

	private String low;

	private String varBid;

	private String pctChange;

	private String bid;

	private String ask;

	private String timestamp;

	private String create_date;
	
}
