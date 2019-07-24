package com.app.pojoss;


public class Carts{

	private long id;

	private Products product;

	private int quantity;
	
	private Customers customer;


	public Carts(long id, Products product, int quantity, Customers customer) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Carts(Products product, int quantity, Customers customer) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Carts() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Products getProduct() {
		return product;
	}


	public void setProduct(Products product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Customers getCustomer() {
		return customer;
	}


	public void setCustomer(Customers customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", quantity=" + quantity + ", customer=" + customer + "]";
	}

	
	

	}
