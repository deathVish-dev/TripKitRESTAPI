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
import javax.validation.constraints.DecimalMin;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "ProductTable")
public class Product implements Serializable {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;



    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 3)
    private String name;



    @Column(name = "description")
    private String description;


    @Column(name = "category")
    private String category;

    
    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00")
    private Double price;
    
    
    @Column(name = "rent", nullable = false)
    @DecimalMin(value = "0.00")
    private Double rent;
    
    @Column(name = "image")
    private String img;
    
    
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    private List<Cart> carts=new ArrayList<Cart>();


	public Product(Long id, String name, String description, String category, Double price, Double rent, String img,
			List<Cart> carts) {
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


	public Product(String name, String description, String category, Double price, Double rent, String img,
			List<Cart> carts) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rent = rent;
		this.img = img;
		this.carts = carts;
	}


	public Product() {
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


	public List<Cart> getCarts() {
		return carts;
	}


	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", rent=" + rent + ", img=" + img + ", carts=" + carts + "]";
	}
    
    
    

    }
