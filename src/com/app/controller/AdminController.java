package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Product;
import com.app.pojoss.Products;



@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/admin") //optional BUT reco
public class AdminController {
	
	@Autowired
	IProductDao productdao;
	
	public AdminController() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>(productdao.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/deleteProduct/{pid}")
	public String deleteProducts(@PathVariable long pid) {

		return productdao.removeProduct(productdao.getProduct(pid));
	}

	@PostMapping("/updateProduct")
	public String updateProductItem(@RequestBody Products obj) {
		System.out.println("In update product");
		System.out.println(obj.toString());
		Product prod=new Product(obj.getId(), obj.getName(), obj.getDescription(),
				obj.getCategory(), obj.getPrice(), obj.getRent(), obj.getImg());
		productdao.updateProduct(prod);
		return "Update";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Products obj) {
		System.out.println("In update product");
		System.out.println(obj.toString());
		Product prod=new Product(obj.getId(), obj.getName(), obj.getDescription(),
				obj.getCategory(), obj.getPrice(), obj.getRent(), obj.getImg());
		productdao.addProduct(prod);
		return "Added";
	}
	
	

}
