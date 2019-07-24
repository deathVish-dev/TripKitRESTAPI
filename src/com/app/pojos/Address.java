package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "AddrTable")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addr_id")
	private int id;
		
		
	@Column(name = "addrline1")	
	private String AddressLine1;
	
	
	@Column(name = "addrline2")
	private String AddressLine2;
	
	@Column(name = "city")
	private String City;
	
	@Column(name = "state")
	private String State;
	
	
	@Column(name = "zipcode")
	private int PostalCode;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="customer_id")
	private Customer cust;
	
	@OneToOne(mappedBy="addr")
	private Order orders;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	public Address(int id, String addressLine1, String addressLine2, String city, String state, int postalCode,
			Customer cust) {
		super();
		this.id = id;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		City = city;
		State = state;
		PostalCode = postalCode;
		this.cust = cust;
	}
	public Address(String addressLine1, String addressLine2, String city, String state, int postalCode, Customer cust) {
		super();
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		City = city;
		State = state;
		PostalCode = postalCode;
		this.cust = cust;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", AddressLine1=" + AddressLine1 + ", AddressLine2=" + AddressLine2 + ", City="
				+ City + ", State=" + State + ", PostalCode=" + PostalCode + ", cust=" + cust + "]";
	}
	
	
}
