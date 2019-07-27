package com.app.pojoss;


import java.util.Date;



public class Orders{
	
    private long id;
    private Inventorys inven;
    private double rent;
    private int quantity;
    private Date bdate;
    private Date rdate; 
    private Customers cust;
    private Addresss addr;
    private CardDtls card;
	public Orders(long id, Inventorys inven, double rent, int quantity, Date bdate, Date rdate, Customers cust,
			Addresss addr, CardDtls card) {
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
	public Orders(Inventorys inven, double rent, int quantity, Date bdate, Date rdate, Customers cust, Addresss addr,
			CardDtls card) {
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
    
    public Orders() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Inventorys getInven() {
		return inven;
	}
	public void setInven(Inventorys inven) {
		this.inven = inven;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
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
	public Customers getCust() {
		return cust;
	}
	public void setCust(Customers cust) {
		this.cust = cust;
	}
	public Addresss getAddr() {
		return addr;
	}
	public void setAddr(Addresss addr) {
		this.addr = addr;
	}
	public CardDtls getCard() {
		return card;
	}
	public void setCard(CardDtls card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", inven=" + inven + ", rent=" + rent + ", quantity=" + quantity + ", bdate="
				+ bdate + ", rdate=" + rdate + ", cust=" + cust + ", addr=" + addr + ", card=" + card + "]";
	}    
    
    

}
