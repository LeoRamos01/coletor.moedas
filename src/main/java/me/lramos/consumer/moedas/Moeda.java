package me.lramos.consumer.moedas;

import lombok.Data;

/**
 * 
 * [{"code":"USD", "codein":"BRL", "name":"Dólar Comercial", "high":"4.1711",
 * "low":"4.1212", "varBid":"-0.0232", "pctChange":"-0.56", "bid":"4.1444",
 * "ask":"4.1461", "timestamp":"1567198798", "create_date":"2019-08-30
 * 21:00:02"}]
 *
 * 
 * @author leonardorm
 *
 */
@Data
public class Moeda {

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
