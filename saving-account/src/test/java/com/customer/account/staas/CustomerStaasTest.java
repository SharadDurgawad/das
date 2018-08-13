package com.customer.account.staas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.customer.account.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerStaasTest {

	
	private static Logger logger  = LogManager.getLogger();

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private AccountService accountService;
	
	@Test
    public void createCustomerWithStaasStubs() throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> stubResponse = restTemplate.getForEntity("http://localhost:9090/staas/saving-account/stub-customer-detail", String.class);
		System.out.println(stubResponse);
		this.mvc.perform(post("/api/customers")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(stubResponse.getBody()))
	            .andExpect(status().is2xxSuccessful());
    }
}
