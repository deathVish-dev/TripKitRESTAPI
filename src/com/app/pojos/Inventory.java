package com.app.pojos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id")
    private Long id;
    
    
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="product_id")
	private Product prod;
    
	@Column(name = "quantity")
	private int quantity;
    
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ven_id")
    private Vendor ven;
    
	@Column(name = "rent")
	private double rent;
	
	
    @OneToMany(mappedBy = "inven")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    private Set<Cart> carts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Vendor getVen() {
		return ven;
	}

	public void setVen(Vendor ven) {
		this.ven = ven;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	
	
	
	public Inventory(Long id, Product prod, int quantity, Vendor ven, double rent) {
		super();
		this.id = id;
		this.prod = prod;
		this.quantity = quantity;
		this.ven = ven;
		this.rent = rent;
	}
	
	
	

	public Inventory(Product prod, int quantity, Vendor ven, double rent) {
		super();
		this.prod = prod;
		this.quantity = quantity;
		this.ven = ven;
		this.rent = rent;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", prod=" + prod + ", quantity=" + quantity + ", ven=" + ven + ", rent=" + rent
				+ "]";
	}
	
	
    
    

}
