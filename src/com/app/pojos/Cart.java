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
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long id;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="product_id")
	private Product product;
	
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="customer_id")
	private Customer customer;


	public Cart(long id, Product product, int quantity, Customer customer) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Cart(Product product, int quantity, Customer customer) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Cart() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
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


	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", quantity=" + quantity + ", customer=" + customer + "]";
	}

	
	

	}
