package com.jumia.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int id;
	private String name;
	private String phone;
	private String state;
	private String countryName;
	
	public Customer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String status) {
		this.state = status;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, phone=%s, state=%s]", id, name, phone, state);
	}

}
