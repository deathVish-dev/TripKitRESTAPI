package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "UserTable")
public class Customer implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
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
    
    @Column(name = "password", nullable = false)
    @Length(min = 8)
    private String pass;
    
    
    @OneToMany(mappedBy = "cust",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    private List<Order> orders=new ArrayList<Order>();
    
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cart> carts=new ArrayList<Cart>();

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

	public Customer(Long id, String name, String mail, String addr, Long phone, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.addr = addr;
		this.phone = phone;
		this.pass = pass;
	}

	public Customer(String name, String mail, String addr, Long phone, String pass) {
		super();
		this.name = name;
		this.mail = mail;
		this.addr = addr;
		this.phone = phone;
		this.pass = pass;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mail=" + mail + ", addr=" + addr + ", phone=" + phone
				+ ", pass=" + pass + ", orders=" + orders + ", carts=" + carts + "]";
	}
    
    
    
        
    
    
    
}
