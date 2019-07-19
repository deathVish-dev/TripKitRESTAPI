package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.dao.ICartDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Product;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/products") //optional BUT reco
public class UserController {

	@Autowired
	ICartDao cartdao;
	@Autowired
	IProductDao productdao;
	
	
	
	public UserController() {
		
		System.out.println("In User Controller");
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllStudents() {

		return new ResponseEntity<List<Product>>(productdao.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/userpage")
	public String loadHomePage(Model map)
	{
		
		List<Product> ls=productdao.getAllProduct();
		map.addAttribute("productlist",ls);
		return "user/userpage";
	}
	
	@GetMapping("/product")
	public String loadProductPage(@RequestParam long id,Model map)
	{
		System.out.println(id);
		map.addAttribute("product",productdao.getProduct(id));
		return "user/product";
	}
	
	@PostMapping("/product")
	public String storeInCart(@RequestParam int count,@RequestParam long pid,HttpSession hs)
	{
		System.out.println("*************************");
		System.out.println(pid+" "+count);
		Customer c=(Customer)hs.getAttribute("useracc");
		Cart cart=new Cart(productdao.getProduct(pid), count, c);
		cartdao.saveInCart(cart);
		//map.addAttribute("product",productdao.getProduct(id));
		return "user/usercart";
	}
	
	/*@GetMapping("/cart")
	public String loadCartPage(HttpSession hs,Model map)
	{
		System.out.println("In Cart Load");
		Customer c=(Customer)hs.getAttribute("useracc");
		List<Cart> cartitems=cartdao.getUserCart(c.getId());
		map.addAttribute("cartitems", cartitems);	
		return "user/usercart";
	}*/

}
