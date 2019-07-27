package com.app.pojoss;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.pojos.Customer;
import com.app.pojos.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Addresss {

	private int id;
	private Customers cust;
	private String state;
	private String addressLine1;
	private int postalCode;
	private String addressLine2;
	private String city;
	
	public Addresss() {
		// TODO Auto-generated constructor stub
	}

	public Addresss(Customers cust, String state, String addressLine1, int postalCode, String addressLine2,
			String city) {
		super();
		this.cust = cust;
		this.state = state;
		this.addressLine1 = addressLine1;
		this.postalCode = postalCode;
		this.addressLine2 = addressLine2;
		this.city = city;
	}

	public Addresss(int id, Customers cust, String state, String addressLine1, int postalCode, String addressLine2,
			String city) {
		super();
		this.id = id;
		this.cust = cust;
		this.state = state;
		this.addressLine1 = addressLine1;
		this.postalCode = postalCode;
		this.addressLine2 = addressLine2;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customers getCust() {
		return cust;
	}

	public void setCust(Customers cust) {
		this.cust = cust;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Addresss [id=" + id + ", cust=" + cust + ", state=" + state + ", addressLine1=" + addressLine1
				+ ", postalCode=" + postalCode + ", addressLine2=" + addressLine2 + ", city=" + city + "]";
	}
	
	
	
	

}
