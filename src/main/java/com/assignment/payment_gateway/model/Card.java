package com.assignment.payment_gateway.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Card {

	private Long number;
	
	private Integer expirationMonth;
	
	private Integer expirationYear;
	
	private Integer cvv;
	
	public Card() {
	}
	

	public Card(Long number, Integer expirationMonth, Integer expirationYear, Integer cvv) {
		super();
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	
	
}
