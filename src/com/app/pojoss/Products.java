package com.app.pojoss;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Products {
	

   
    private Long id;



   
    private String name;



   
    private String description;


    
    private String category;


    private Double price;
    

    private Double rent;
    
    
    private String img;
    

    private Set<Carts> carts;


	public Products(Long id, String name, String description, String category, Double price, Double rent, String img,
			Set<Carts> carts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rent = rent;
		this.img = img;
		this.carts = carts;
	}


	public Products(String name, String description, String category, Double price, Double rent, String img,
			Set<Carts> carts) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rent = rent;
		this.img = img;
		this.carts = carts;
	}


	public Products() {
		super();
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getRent() {
		return rent;
	}


	public void setRent(Double rent) {
		this.rent = rent;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Set<Carts> getCarts() {
		return carts;
	}


	public void setCarts(Set<Carts> carts) {
		this.carts = carts;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", rent=" + rent + ", img=" + img + ", carts=" + carts + "]";
	}
    
    
    

    }
