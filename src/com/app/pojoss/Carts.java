package com.app.pojoss;


public class Carts{

	private long id;
	private int quantity;
	private Inventorys inven;
	private Customers cust;
	
	
	public Carts(long id, int quantity, Inventorys inven, Customers cust) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.inven = inven;
		this.cust = cust;
	}
	public Carts(int quantity, Inventorys inven, Customers cust) {
		super();
		this.quantity = quantity;
		this.inven = inven;
		this.cust = cust;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Inventorys getInven() {
		return inven;
	}
	public void setInven(Inventorys inven) {
		this.inven = inven;
	}
	public Customers getCust() {
		return cust;
	}
	public void setCust(Customers cust) {
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "Carts [id=" + id + ", quantity=" + quantity + ", inven=" + inven + ", cust=" + cust + "]";
	}
	
	
	}
