package com.assignment.payment_gateway.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment.payment_gateway.config.PaymentResponse;
import com.assignment.payment_gateway.model.Card;
import com.assignment.payment_gateway.model.PaymentDetails;
import com.assignment.payment_gateway.service.PaymentValidationService;

@Controller
@RequestMapping("/gateway")
public class PaymentController {

	@Autowired
	private PaymentValidationService validationSevice;

	
	@RequestMapping(value = "/pay" , method = RequestMethod.POST)
	@ResponseBody
	public PaymentResponse acceptPayment(@RequestBody PaymentDetails paymentDetails) throws Exception{
		
		validationSevice.validate(paymentDetails);
		
		return new PaymentResponse(paymentDetails.getAmount(), paymentDetails.getCurrency(), paymentDetails.getType(), new Card(paymentDetails.getCard().getNumber() , null , null , null), "Success", "SDSD23232333", new Date());
	}
	
}
