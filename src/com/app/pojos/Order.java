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
    @JoinColumn(name = "inven_id")
    private Inventory inven ;

    
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
    
    @OneToOne
    @JoinColumn(name = "card_id")
    private CardDetails card;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Inventory getInven() {
		return inven;
	}

	public void setInven(Inventory inven) {
		this.inven = inven;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
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

	public Order(Long id, Inventory inven, Double rent, int quantity, Date bdate, Date rdate, Customer cust,
			Address addr, CardDetails card) {
		super();
		this.id = id;
		this.inven = inven;
		this.rent = rent;
		this.quantity = quantity;
		this.bdate = bdate;
		this.rdate = rdate;
		this.cust = cust;
		this.addr = addr;
		this.card = card;
	}

	public Order(Inventory inven, Double rent, int quantity, Date bdate, Date rdate, Customer cust, Address addr,
			CardDetails card) {
		super();
		this.inven = inven;
		this.rent = rent;
		this.quantity = quantity;
		this.bdate = bdate;
		this.rdate = rdate;
		this.cust = cust;
		this.addr = addr;
		this.card = card;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", inven=" + inven + ", rent=" + rent + ", quantity=" + quantity + ", bdate=" + bdate
				+ ", rdate=" + rdate + ", cust=" + cust + ", addr=" + addr + ", card=" + card + "]";
	}


    
    
    

}
