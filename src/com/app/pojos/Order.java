package com.app.pojos;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "OrderTable")
public class Order implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

	@ManyToOne
	@JsonManagedReference
    @JoinColumn(name = "product_id")
    private Product prod ;

    
    @Column(name = "rent", nullable = false)
    @DecimalMin(value = "0.00")
    private Double rent;
    
    
    @Column(name = "quantity")
    private int quantity;
    
    
    @Column(name = "bookdate")
    @Temporal(TemporalType.DATE)
    private Date bdate;
    
    
    @Column(name = "returndate")
    @Temporal(TemporalType.DATE)
    private Date rdate;
    
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "cust_id")
    private Customer cust;
    
    @OneToOne
    @JoinColumn(name = "addr_id")
    private Address addr;

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

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Order(Long id, Product prod, Double rent, int quantity, Date bdate, Date rdate, Customer cust) {
		super();
		this.id = id;
		this.prod = prod;
		this.rent = rent;
		this.quantity = quantity;
		this.bdate = bdate;
		this.rdate = rdate;
		this.cust = cust;
	}

	public Order(Product prod, Double rent, int quantity, Date bdate, Date rdate, Customer cust) {
		super();
		this.prod = prod;
		this.rent = rent;
		this.quantity = quantity;
		this.bdate = bdate;
		this.rdate = rdate;
		this.cust = cust;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", prod=" + prod + ", rent=" + rent + ", quantity=" + quantity + ", bdate=" + bdate
				+ ", rdate=" + rdate + ", cust=" + cust + "]";
	}
    
    
    

}
