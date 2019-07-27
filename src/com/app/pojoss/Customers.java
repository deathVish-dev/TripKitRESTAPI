package com.app.pojoss;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.app.pojos.Address;
import com.app.pojos.Cart;
import com.app.pojos.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class Customers{

	
    private Long id;
    private String name;
    private String mail;
    private String addr;
    private Long phone;
    private String pass;
    private Set<Orders> orders;
    private Set<Carts> carts;
    private Set<Address> addrs;

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Customers(Long id, String name, String mail, String addr, Long phone, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.addr = addr;
		this.phone = phone;
		this.pass = pass;
	}

	public Customers(String name, String mail, String addr, Long phone, String pass) {
		super();
		this.name = name;
		this.mail = mail;
		this.addr = addr;
		this.phone = phone;
		this.pass = pass;
	}

	public Customers() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + ", addr=" + addr + ", phone=" + phone
				+ ", pass=" + pass + ", orders=" + orders + ", carts=" + carts + "]";
	}
    
    
    
        
    
    
    
}
