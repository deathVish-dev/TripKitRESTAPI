package com.app.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "CartTable")
public class Cart{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long id;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="inven_id")
	private Inventory inven;
	
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="customer_id")
	private Customer customer;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Inventory getInven() {
		return inven;
	}


	public void setInven(Inventory inven) {
		this.inven = inven;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Cart(long id, Inventory inven, int quantity, Customer customer) {
		super();
		this.id = id;
		this.inven = inven;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Cart(Inventory inven, int quantity, Customer customer) {
		super();
		this.inven = inven;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Cart() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", inven=" + inven + ", quantity=" + quantity + ", customer=" + customer + "]";
	}
	
	
	

	}
