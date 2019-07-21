package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICartDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Product;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/user") //optional BUT reco
public class UserController {

	@Autowired
	ICartDao cartdao;
	@Autowired
	IProductDao productdao;
	
	
	
	public UserController() {
		
		System.out.println("In User Controller");
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>(productdao.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable long pid) {

		return productdao.getProduct(pid);
	}
	
	@GetMapping("/prodcart/{uid}/{pid}")
	public Cart getCart(@PathVariable long uid,@PathVariable long pid) {

		return cartdao.prodCart(uid, pid);
	}
	
	@PostMapping("/storecart/{uid}/{pid}")
	public String storeInCart(@PathVariable long uid,@PathVariable long pid) {
		
		return null;
	}


}
