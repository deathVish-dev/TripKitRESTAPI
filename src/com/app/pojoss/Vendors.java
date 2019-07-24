package com.app.pojoss;

import java.util.List;
import java.util.Set;

import com.app.pojos.Inventory;

public class Vendors {
	
	    private Long id;


	    private String name;
	    
	  
	    private String mail;
	    
	   
	    private String addr;
	    
	   private Long phone;
	    
	    private String shopid;
	    
	    private String shopaddr;
	    
	    
	    private String permission;
	    
	    private String pass;


	   Set<Inventorys> products;
	    
	    
	    public Vendors(Long id, String name, String mail, String addr, Long phone, String shopid, String shopaddr,
				String permission, String pass) {
			super();
			this.id = id;
			this.name = name;
			this.mail = mail;
			this.addr = addr;
			this.phone = phone;
			this.shopid = shopid;
			this.shopaddr = shopaddr;
			this.permission = permission;
			this.pass = pass;
		}

	    
	    

		public Vendors(String name, String mail, String addr, Long phone, String shopid, String shopaddr,
				String permission, String pass) {
			super();
			this.name = name;
			this.mail = mail;
			this.addr = addr;
			this.phone = phone;
			this.shopid = shopid;
			this.shopaddr = shopaddr;
			this.permission = permission;
			this.pass = pass;
		}




		public Vendors() {
			// TODO Auto-generated constructor stub
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public String getAddr() {
			return addr;
		}


		public void setAddr(String addr) {
			this.addr = addr;
		}


		public Long getPhone() {
			return phone;
		}


		public void setPhone(Long phone) {
			this.phone = phone;
		}


		public String getShopid() {
			return shopid;
		}


		public void setShopid(String shopid) {
			this.shopid = shopid;
		}


		public String getShopaddr() {
			return shopaddr;
		}


		public void setShopaddr(String shopaddr) {
			this.shopaddr = shopaddr;
		}


		public String getPermission() {
			return permission;
		}


		public void setPermission(String permission) {
			this.permission = permission;
		}


		
		
		
		public String getPass() {
			return pass;
		}




		public void setPass(String pass) {
			this.pass = pass;
		}

		
		



		public Set<Inventorys> getProducts() {
			return products;
		}




		public void setProducts(Set<Inventorys> products) {
			this.products = products;
		}




		@Override
		public String toString() {
			return "Vendor [id=" + id + ", name=" + name + ", mail=" + mail + ", addr=" + addr + ", phone=" + phone
					+ ", shopid=" + shopid + ", shopaddr=" + shopaddr + ", permission=" + permission + "]";
		}
	    
	    
	    
	    
	    
	    

}
