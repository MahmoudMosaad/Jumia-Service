package com.jumia.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumia.demo.customerServices.CustomerServices;
import com.jumia.demo.models.Customer;
import com.jumia.demo.utility.CategorizePhone;
import com.jumia.demo.utility.CountryPhoneDetails;



@SpringBootTest(classes =JumiaServicesExerciseApplication.class)
public class CustomerTest {
	
	List<CountryPhoneDetails> countryDetails = Arrays.asList(
			new CountryPhoneDetails("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$", "(237)"),
			new CountryPhoneDetails("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$", "(251)"),
			new CountryPhoneDetails("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$", "(212)"),
			new CountryPhoneDetails("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$", "(258)"),
			new CountryPhoneDetails("Uganda", "\\(256\\)\\ ?\\d{9}$", "(256)"));
	
	@Autowired
	CustomerServices repo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void findAllTest() {
		assertNotNull(repo.findAll());
	}
	
	@Test
	void filterTest() {
		logger.info("data is : "+ repo.findByStartWith("(237)"));
		assertNotNull(repo.findByStartWith("(237)"));
	}
	
	@Test
	void categorizeTest() {
		List<Customer> list = repo.findByStartWith("(237)");
		CountryPhoneDetails c = countryDetails.stream().filter(country -> country.getPhoneStartWith().equals("(237)"))
				.findFirst().get(); 
		assertNotNull(CategorizePhone.getCategorizePhone(list, c));
	}
	
	@Test
	void categorizeAllTest() {
		List<Customer> list = repo.findAll();
		assertNotNull(CategorizePhone.getCategorizePhone(list, countryDetails));
	}
	
	

}
