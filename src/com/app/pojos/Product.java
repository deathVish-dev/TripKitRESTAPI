package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ProductTable")
public class Product {
	

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
    
    
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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
