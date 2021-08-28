package com.jumia.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jumia.demo.customerServices.CustomerServices;
import com.jumia.demo.models.Customer;
import com.jumia.demo.utility.CategorizePhone;
import com.jumia.demo.utility.CountryPhoneDetails;
import com.jumia.demo.utility.FilterData;
import com.jumia.demo.utility.GetFilterData;


@Controller
public class CustomerController {

	@Autowired
	private CustomerServices customerService;
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	List<CountryPhoneDetails> countryDetails = Arrays.asList(
			new CountryPhoneDetails("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$", "(237)"),
			new CountryPhoneDetails("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$", "(251)"),
			new CountryPhoneDetails("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$", "(212)"),
			new CountryPhoneDetails("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$", "(258)"),
			new CountryPhoneDetails("Uganda", "\\(256\\)\\ ?\\d{9}$", "(256)"));

	@GetMapping("/")
	public String getData(ModelMap model) {

		return findPaginated(1, model);
	}

	@PostMapping("/filter")
	public String getFilteredData(ModelMap model, @ModelAttribute("getFilterData") GetFilterData getFilterData) {

		if (getFilterData.getSelectedCountryName().equals("All") && getFilterData.getSelectedValideNotValid().equals("All"))
			return "redirect:/";
		else if(getFilterData.getSelectedCountryName().equals("All") && !getFilterData.getSelectedValideNotValid().equals("All")){
			
			List<Customer> list = customerService.findAll();
			model.addAttribute("countryDetails", countryDetails);
			model.addAttribute("customers", FilterData.getFilteredData(list, countryDetails, getFilterData.getSelectedCountryName(), getFilterData.getSelectedValideNotValid()));
			return "home";
		}
		else 
		{
			
			List<Customer> list = customerService.findByStartWith(getFilterData.getSelectedCountryName());
			model.addAttribute("countryDetails", countryDetails);
			model.addAttribute("customers", FilterData.getFilteredData(list, countryDetails, getFilterData.getSelectedCountryName(), getFilterData.getSelectedValideNotValid()));
			logger.info(""+list);
			return "home";
		}
		
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, ModelMap model) {

		int pageSize = 7; 

		Page<Customer> page = customerService.findPaginated(pageNo, pageSize);
		List<Customer> list = CategorizePhone.getCategorizePhone(page.getContent(), countryDetails);
		GetFilterData getFilterData = new GetFilterData("All","All");
		model.addAttribute("currentPage", pageNo); 
		model.addAttribute("totalPages", page.getTotalPages()); 
		model.addAttribute("totalItems", page.getTotalElements()); 
		model.addAttribute("countryDetails", countryDetails);
		model.addAttribute("customers", list);
		model.addAttribute("getFilterData", getFilterData);

		return "home";
	}
	
	
}
