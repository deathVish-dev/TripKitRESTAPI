package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "VendorTable")
public class Vendor implements Serializable {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "vendor_id")
	    private Long id;

	    @Column(name = "name", nullable = false)
	    @Length(min = 3)
	    private String name;
	    
	    @Column(name = "mail", nullable = false, unique = true)
	    @Length(min = 3)
	    private String mail;
	    
	    @Column(name = "addr", nullable = false)
	    @Length(min = 3)
	    private String addr;
	    
	    @Column(name = "phone", nullable = false,unique = true)
	    private Long phone;
	    
	    @Column(name = "shopid", nullable = false, unique = true)
	    @Length(min = 8)
	    private String shopid;
	    
	    @Column(name = "shopaddr", nullable = false)
	    @Length(min = 3)
	    private String shopaddr;
	    
	    
	    @Column(name = "permission", nullable = false)
	    @Length(min = 1)
	    private String permission;
	    
	    @Column(name = "password", nullable = false)
	    @Length(min = 8)
	    private String pass;


	    @OneToMany(mappedBy = "ven",cascade = CascadeType.ALL)
	    @LazyCollection(LazyCollectionOption.FALSE)
	    List<Inventory> products=new ArrayList<Inventory>();
	    
	    
	    public Vendor(Long id, String name, String mail, String addr, Long phone, String shopid, String shopaddr,
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

	    
	    

		public Vendor(String name, String mail, String addr, Long phone, String shopid, String shopaddr,
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




		public Vendor() {
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

		
		



		public List<Inventory> getProducts() {
			return products;
		}




		public void setProducts(List<Inventory> products) {
			this.products = products;
		}




		@Override
		public String toString() {
			return "Vendor [id=" + id + ", name=" + name + ", mail=" + mail + ", addr=" + addr + ", phone=" + phone
					+ ", shopid=" + shopid + ", shopaddr=" + shopaddr + ", permission=" + permission + "]";
		}
	    
	    
	    
	    
	    
	    

}
