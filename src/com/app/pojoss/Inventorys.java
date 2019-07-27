package com.app.pojoss;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Inventorys {
    
	private Long id;
    private Products prod;
	private int quantity;
    private Vendors ven;
	private double rent;
	
	public Inventorys() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Products getProd() {
		return prod;
	}

	public void setProd(Products prod) {
		this.prod = prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Vendors getVen() {
		return ven;
	}

	public void setVen(Vendors ven) {
		this.ven = ven;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Inventorys [id=" + id + ", prod=" + prod + ", quantity=" + quantity + ", ven=" + ven + ", rent=" + rent
				+ "]";
	}
	
	

}
