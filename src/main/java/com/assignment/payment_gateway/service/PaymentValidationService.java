package com.assignment.payment_gateway.service;

import org.springframework.stereotype.Service;

import com.assignment.payment_gateway.model.PaymentDetails;

@Service
public class PaymentValidationService {

	private static final String CREDIT_CARD = "creditcard";
	private static final String DEBIT_CARD = "debitcard";
	
	public static int getCardNumberLength(Long number) {
		String num = number + "";
		return num.length();
	}

	public static int getCvvLength(Integer number) {

		String num = number + "";
		return num.length();
	}

	public void validate(PaymentDetails paymentDetails) {

		if (paymentDetails == null)
			throw new IllegalArgumentException("Payment Details Not Found");

		String type = paymentDetails.getType();

		if (!type.equals(CREDIT_CARD) && !type.equals(DEBIT_CARD))
			throw new IllegalArgumentException("Unsupported Payment Type");

		if (paymentDetails.getAmount() <= 0)
			throw new IllegalArgumentException("Amount can't be less than one");

		if (paymentDetails.getCard() == null)
			throw new IllegalArgumentException("Card Details are missing");

		if (getCardNumberLength(paymentDetails.getCard().getNumber()) != 16)
			throw new IllegalArgumentException("Wrong Card Number");

		if (getCvvLength(paymentDetails.getCard().getCvv()) != 3)
			throw new IllegalArgumentException("Wrong CVV Number");
	}

}
