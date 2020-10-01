package com.assignment.payment_gateway.model;

public class PaymentDetails {
	
	private Integer amount;
	
	private String currency;
	
	private String type;
	
	private Card card;
	
	public PaymentDetails() {
		
	}
	
	public PaymentDetails(Integer amount, String currency, String type, Card card) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.type = type;
		this.card = card;
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

	@Override
	public String toString() {
		return "PaymentDetails [amount=" + amount + ", currency=" + currency + ", type=" + type + ", card=" + card
				+ "]";
	}
	
	

}
