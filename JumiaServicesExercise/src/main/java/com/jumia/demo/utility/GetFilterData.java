package com.jumia.demo.utility;

public class GetFilterData {

	private String selectedCountryName;
	private String selectedValideNotValid;
	
	public GetFilterData() {
	}
	
	public GetFilterData(String selectedCountryName, String selectedValideNotValid) {
		super();
		this.selectedCountryName = selectedCountryName;
		this.selectedValideNotValid = selectedValideNotValid;
	}
	public String getSelectedCountryName() {
		return selectedCountryName;
	}
	public void setSelectedCountryName(String selectedCountryName) {
		this.selectedCountryName = selectedCountryName;
	}
	public String getSelectedValideNotValid() {
		return selectedValideNotValid;
	}
	public void setSelectedValideNotValid(String selectedValideNotValid) {
		this.selectedValideNotValid = selectedValideNotValid;
	}
	
	
	
}
