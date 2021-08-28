package com.jumia.demo.utility;

public class CountryPhoneDetails {
	
	private String countryName;
	private String regexValidation;
	private String phoneStartWith;
	
	public CountryPhoneDetails(String countryName, String regexValidation, String phoneStartWith) {
		super();
		this.countryName = countryName;
		this.phoneStartWith = phoneStartWith;
		this.regexValidation = regexValidation;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPhoneStartWith() {
		return phoneStartWith;
	}

	public void setPhoneStartWith(String phoneStartWith) {
		this.phoneStartWith = phoneStartWith;
	}

	public String getRegexValidation() {
		return regexValidation;
	}

	public void setRegexValidation(String regexValidation) {
		this.regexValidation = regexValidation;
	}

	@Override
	public String toString() {
		return String.format("CountryPhoneDetails [countryName=%s, regexValidation=%s, phoneStartWith=%s]", countryName,
				regexValidation, phoneStartWith);
	}
	
	

}
