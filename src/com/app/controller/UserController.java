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

import com.app.dao.ICartDao;
import com.app.dao.ICustomerDao;
import com.app.dao.ILoginDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Product;
import com.app.pojoss.Carts;
import com.app.pojoss.Customers;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/user") //optional BUT reco
public class UserController {

	@Autowired
	ICartDao cartdao;
	@Autowired
	IProductDao productdao;
	@Autowired
	ICustomerDao custdao;	
	@Autowired
	ILoginDao ldao;
	
	
	public UserController() {
		
		System.out.println("In User Controller");
	}
	
	@GetMapping("/getuser/{uname}/{pass}")
	public Customer custDetails(@PathVariable String uname,@PathVariable String pass) {
		Customer c=custdao.getCustomerAcc(uname, pass);
		return c;
	}
	
	@PostMapping("/reguser")
	public String regUser(@RequestBody Customers cust) {
		System.out.println("In User registration");
		Customer c= new Customer(cust.getName(), cust.getMail(), cust.getAddr(), cust.getPhone(), cust.getPass());
		Login l=new Login(cust.getMail(), cust.getPass(), "Customer");
		System.out.println(custdao.regCustomer(c).getId());
		ldao.reg(l);
		return "Registered Successfully";
	}
	
	@PostMapping("/updateuser")
	public String updateUser(@RequestBody Customers cust) {
		System.out.println("In update cart");
		System.out.println(cust.toString());
	
		//System.out.println(cart.getQuantity());
		return "Update";
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
	
	@PostMapping("/updatecart")
	public String storeInCart(@RequestBody Carts obj) {
		System.out.println("In update cart");
		System.out.println(obj.toString());
		Customer cust=new Customer(obj.getCustomer().getId(), obj.getCustomer().getName(), obj.getCustomer().getMail(),
				obj.getCustomer().getAddr(), obj.getCustomer().getPhone(), obj.getCustomer().getPass());
		Product prod=new Product(obj.getProduct().getId(), obj.getProduct().getName(), obj.getProduct().getDescription(),
				obj.getProduct().getCategory(), obj.getProduct().getPrice(), obj.getProduct().getRent(), obj.getProduct().getImg());
		Cart c=new Cart(obj.getId(),prod, obj.getQuantity(), cust);
		System.out.println(c.toString());
		System.out.println(cartdao.saveInCart(c));		
		return "Update";
	}
	
	@GetMapping("/getAllCart/{uid}")
	public ResponseEntity<List<Cart>> getAllCartItems(@PathVariable long uid) {

		return new ResponseEntity<List<Cart>>(cartdao.getUserCart(uid),HttpStatus.OK);
	}
	
	@GetMapping("/getusermails")
	public ResponseEntity<List<String>> getAllUserMails() {

		return new ResponseEntity<List<String>>(custdao.getMails(),HttpStatus.OK);
	}

	

}
