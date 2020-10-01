package com.assignment.payment_gateway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.assignment.payment_gateway.config.PaymentResponse;
import com.assignment.payment_gateway.model.Card;
import com.assignment.payment_gateway.model.PaymentDetails;

@SpringBootTest
class DemoApplicationTests {

	private static final String URL = "http://localhost:8080";

	@Test
	public void payShouldReturnSuccess() throws Exception {
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		PaymentDetails payment = new PaymentDetails(100, "USD", "creditcard",
				new Card(4111111111111111l, 2, 2020, 111));
		
		PaymentResponse response = restTemplate.postForObject(URL +"/gateway/pay", payment, PaymentResponse.class);

		assertThat(response.getStatus().equals("success"));
	}
	
	
	@Test
	public void payShouldReturnFailure() throws Exception {
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		PaymentDetails payment = new PaymentDetails(100, "USD", "xxxcard",
				new Card(4111111111111111l, 2, 2020, 111));
		
		restTemplate.postForObject(URL +"/gateway/pay", payment, PaymentResponse.class);

		assertThatIllegalStateException();
	}
}
