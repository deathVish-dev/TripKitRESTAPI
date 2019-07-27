package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CardDetails")
public class CardDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "card_id")
	private long id;
	
	private long aadharcard;
	
	private String pancard;
	
	private long ccno;
	
	private int cvv;
	
	@OneToOne(mappedBy = "card")
	private Order orders;

	public CardDetails(long id, long aadharcard, String pancard, long ccno, int cvv) {
		super();
		this.id = id;
		this.aadharcard = aadharcard;
		this.pancard = pancard;
		this.ccno = ccno;
		this.cvv = cvv;
	}

	public CardDetails(long aadharcard, String pancard, long ccno, int cvv) {
		super();
		this.aadharcard = aadharcard;
		this.pancard = pancard;
		this.ccno = ccno;
		this.cvv = cvv;
	}

	public CardDetails() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(long aadharcard) {
		this.aadharcard = aadharcard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getCcno() {
		return ccno;
	}

	public void setCcno(long ccno) {
		this.ccno = ccno;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CardDetails [id=" + id + ", aadharcard=" + aadharcard + ", pancard=" + pancard + ", ccno=" + ccno
				+ ", cvv=" + cvv + ", orders=" + orders + "]";
	}
	
	
	

}
