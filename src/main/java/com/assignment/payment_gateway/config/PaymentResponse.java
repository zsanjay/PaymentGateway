package com.assignment.payment_gateway.config;

import java.util.Date;

import com.assignment.payment_gateway.model.Card;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PaymentResponse {
	
	private Integer amount;
	
	private String currency;
	
	private String type;
	
	private Card card;
	
	private String status;
	
	private String authorization_code;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss" ,timezone = "Asia/Kolkata")
	private Date time;
	
	public PaymentResponse() {
		
	}
	
	public PaymentResponse(Integer amount, String currency, String type, Card card, String status,
			String authorization_code, Date time) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.type = type;
		this.card = card;
		this.status = status;
		this.authorization_code = authorization_code;
		this.time = time;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthorization_code() {
		return authorization_code;
	}

	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	

}
