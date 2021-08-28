package com.jumia.demo.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.jumia.demo.models.Customer;

public class FilterData {

	
	
	
public static List<Customer> getFilteredData(List<Customer> data,List<CountryPhoneDetails> countryDetails,String countryName , String state){
	List<Customer> stateList = null;
	if (!countryName.equals("All") && !state.equals("All")) {
		CountryPhoneDetails c = countryDetails.stream().filter(country -> country.getPhoneStartWith().equals(countryName))
				.findFirst().get();
		List<Customer> cat = CategorizePhone.getCategorizePhone(data, c);
	    stateList = cat.stream().filter(customer -> customer.getState().equals(state))
				.collect(Collectors.toList());
		
	}
	else if(!countryName.equals("All") && state.equals("All"))
	{
		CountryPhoneDetails c = countryDetails.stream().filter(country -> country.getPhoneStartWith().equals(countryName))
				.findFirst().get();
		stateList = CategorizePhone.getCategorizePhone(data, c);	
	}
	else if(countryName.equals("All") && !state.equals("All"))
	{
		stateList = CategorizePhone.getCategorizePhone(data, countryDetails).stream().filter(customer -> customer.getState().equals(state))
				.collect(Collectors.toList());
	}

	return stateList;
	
	}

}
