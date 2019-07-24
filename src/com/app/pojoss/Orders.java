package com.app.pojoss;


import java.util.Date;



public class Orders{
	

    private Long id;

    
    private Long pid;

  
    private String name;
    
    
   
    private Double rent;
    
    
    
    private int quantity;
    
    
    
    private Date bdate;
    
    

    private Date rdate;
    
    
    private Customers cust;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Customers getCust() {
		return cust;
	}


	public void setCust(Customers cust) {
		this.cust = cust;
	}


	public Orders(Long id, Long pid, String name, Double rent, int quantity, Date bdate, Date rdate, Customers cust) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.rent = rent;
		this.quantity = quantity;
		this.bdate = bdate;
		this.rdate = rdate;
		this.cust = cust;
	}


	public Orders() {
		super();
	}
    
    
    

}
