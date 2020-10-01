package com.assignment.payment_gateway.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.payment_gateway.config.PaymentResponse;
import com.assignment.payment_gateway.model.Card;
import com.assignment.payment_gateway.model.CardDetails;
import com.assignment.payment_gateway.model.OrderDetails;
import com.assignment.payment_gateway.model.OrderDetailsResponse;
import com.assignment.payment_gateway.model.PaymentDetails;
import com.assignment.payment_gateway.repo.CardRepository;
import com.assignment.payment_gateway.repo.OrderRepository;
import com.assignment.payment_gateway.repo.OrderResponseRepository;

@Service
public class LoggingServiceImpl implements LoggingService{
	
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderResponseRepository orderResponseRepo;

	@Autowired
	private CardRepository cardRepo;
	
	@Override
	public void logRequest(HttpServletRequest httpServletRequest, Object body) {
		
		PaymentDetails payment = (PaymentDetails)body;
		Card card = payment.getCard();
		
		CardDetails cardDetails = new CardDetails();
		cardDetails.setNumber(card.getNumber());
		cardDetails.setCvv(card.getCvv());
		cardDetails.setExpirationMonth(card.getExpirationMonth());
		cardDetails.setExpirationYear(card.getExpirationYear());
		
		cardDetails = cardRepo.save(cardDetails);
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setAmount(payment.getAmount());
		orderDetails.setCurrency(payment.getCurrency());
		orderDetails.setType(payment.getType());
		orderDetails.setCard(cardDetails);
		orderDetails.setOrderDate(new Date());
		
		orderRepo.save(orderDetails);
	}

	@Override
	public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object body) {
		
		
		OrderDetailsResponse orderDetails = new OrderDetailsResponse();
		
		if(body instanceof PaymentResponse) {

			PaymentResponse payResponse = (PaymentResponse)body;

			orderDetails.setAmount(payResponse.getAmount());
			orderDetails.setCurrency(payResponse.getCurrency());
			orderDetails.setType(payResponse.getType());
			orderDetails.setStatus(httpServletResponse.getStatus());
			orderResponseRepo.save(orderDetails);
		}
		
	}

}
