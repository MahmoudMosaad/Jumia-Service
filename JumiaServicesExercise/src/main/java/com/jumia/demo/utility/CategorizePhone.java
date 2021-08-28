package com.jumia.demo.utility;

import java.util.ArrayList;
import java.util.List;

import com.jumia.demo.models.Customer;

public class CategorizePhone {

	public static List<Customer> getCategorizePhone(List<Customer> list, List<CountryPhoneDetails> countryDetails) {
		List<Customer> categorizedPhone = new ArrayList<>();
		for (Customer c : list) {
			for (CountryPhoneDetails cd : countryDetails)
				if (c.getPhone().startsWith(cd.getPhoneStartWith())) {

					if (c.getPhone().matches(cd.getRegexValidation()))
						c.setState("Valid");
					else
						c.setState("Not Valid");
					c.setCountryName(cd.getCountryName());
					categorizedPhone.add(c);

				}
		}

		return categorizedPhone;
	}

	public static List<Customer> getCategorizePhone(List<Customer> list, CountryPhoneDetails countryDetails) {
		List<Customer> categorizedPhone = new ArrayList<>();
		for (Customer c : list) {
			if (c.getPhone().startsWith(countryDetails.getPhoneStartWith())) {

				if (c.getPhone().matches(countryDetails.getRegexValidation()))
					c.setState("Valid");
				else
					c.setState("Not Valid");
				c.setCountryName(countryDetails.getCountryName());
				categorizedPhone.add(c);

			}
		}
		return categorizedPhone;
	}

}
