package com.provensi.response;

import java.math.BigDecimal;

public class Cambio {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactor;
	private BigDecimal conversionValue;

	private String enviroment;

	public Cambio() {
	}

	public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal conversionValue,
			String enviroment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.conversionValue = conversionValue;
		this.enviroment = enviroment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public BigDecimal getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
}
