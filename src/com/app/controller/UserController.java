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
import com.app.pojos.Address;
import com.app.pojos.CardDetails;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Inventory;
import com.app.pojos.Login;
import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.Vendor;
import com.app.pojoss.Addresss;
import com.app.pojoss.CardDtls;
import com.app.pojoss.Carts;
import com.app.pojoss.Customers;
import com.app.pojoss.Inventorys;
import com.app.pojoss.Orders;
import com.app.pojoss.Products;
import com.app.pojoss.Vendors;

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

		System.out.println(uid+" "+pid);
		return cartdao.prodCart(uid, pid);
	}
	
	@GetMapping("/deletecart/{cid}")
	public String removeCart(@PathVariable long cid) {
		System.out.println("In Delete cart");
		System.out.println(cartdao.removeCart(cid));
		return "Update";
	}
	@PostMapping("/addtocart")
	public String storeInCart(@RequestBody Carts obj) {
		System.out.println("In Add cart*************");
		System.out.println(obj.toString());
		Inventorys invens=obj.getInven();
		Products prods=invens.getProd();
		Vendors vens=invens.getVen();
		
		
		Customer cust=new Customer(obj.getCust().getId(), obj.getCust().getName(), obj.getCust().getMail(),
				obj.getCust().getAddr(), obj.getCust().getPhone(), obj.getCust().getPass());
		
		
		Product prod=new Product(prods.getId(),prods.getName(),prods.getDescription(),prods.getCategory(),prods.getPrice(),
				prods.getRent(),prods.getImg());
		
		Vendor ven=new Vendor(vens.getId(),vens.getName(),vens.getMail(),vens.getAddr(),vens.getPhone(),
				vens.getShopid(),vens.getShopaddr(),vens.getPermission(),vens.getPass());
		
		Inventory inven=new Inventory(invens.getId(), prod, invens.getQuantity(),ven, invens.getRent());
		
		Cart c=new Cart(obj.getId(),inven,obj.getQuantity(),cust);
		System.out.println(c.toString());
		System.out.println(cartdao.saveInCart(c));		
		return "Added Successfully";
	}
	
	@GetMapping("/getAllCart/{uid}")
	public ResponseEntity<List<Cart>> getAllCartItems(@PathVariable long uid) {

		return new ResponseEntity<List<Cart>>(cartdao.getUserCart(uid),HttpStatus.OK);
	}
	
	@GetMapping("/getusermails")
	public ResponseEntity<List<String>> getAllUserMails() {

		return new ResponseEntity<List<String>>(custdao.getMails(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addaddr")
	public String addAddress(@RequestBody Addresss obj) {
		System.out.println("In Add Address*************");
		System.out.println(obj.toString());
		Customers custs=obj.getCust();
		
		Customer cust=new Customer(custs.getId(),custs.getName(), custs.getMail(), 
				custs.getAddr(), custs.getPhone(), custs.getPass());
		
		Address addr=new Address(obj.getAddressLine1(), obj.getAddressLine2(), obj.getCity()
				, obj.getState(), obj.getPostalCode(),cust);
		System.out.println(custdao.addAddr(addr).toString());
		
		return "Address Added Successfully";
	}
	
	@PostMapping("/updateaddr")
	public String updateAddress(@RequestBody Addresss obj) {
		System.out.println("In Update Address*************");
		System.out.println(obj.toString());
		Customers custs=obj.getCust();
		
		Customer cust=new Customer(custs.getId(),custs.getName(), custs.getMail(), 
				custs.getAddr(), custs.getPhone(), custs.getPass());
		
		Address addr=new Address(obj.getId(),obj.getAddressLine1(), obj.getAddressLine2(), obj.getCity()
				, obj.getState(), obj.getPostalCode(),cust);
	System.out.println(custdao.updateAddr(addr).toString());
		
		return "Address Updated Successfully";
	}
	
	@PostMapping("/addcard")
	public CardDetails addCard(@RequestBody CardDtls obj) {
		System.out.println("In Add Card*************");
		System.out.println(obj.toString());
		CardDetails cd=new CardDetails(obj.getAadharcard(),obj.getPancard(),obj.getCcno(),obj.getCvv());	
		System.out.println(custdao.addCard(cd).toString());
		return cd;
	}
	
	@PostMapping("/storeUserOrders")
	public void storeUserOrder(@RequestBody Orders obj) {
		System.out.println("In Add Orders*************");
		System.out.println(obj.toString());
		Addresss ad=obj.getAddr();
		CardDtls cd=obj.getCard();
		Inventorys invens=obj.getInven();
		Products prods=invens.getProd();
		Vendors vens=invens.getVen();
		
		
		Customer cust=new Customer(obj.getCust().getId(), obj.getCust().getName(), obj.getCust().getMail(),
				obj.getCust().getAddr(), obj.getCust().getPhone(), obj.getCust().getPass());
		
		
		Product prod=new Product(prods.getId(),prods.getName(),prods.getDescription(),prods.getCategory(),prods.getPrice(),
				prods.getRent(),prods.getImg());
		
		Vendor ven=new Vendor(vens.getId(),vens.getName(),vens.getMail(),vens.getAddr(),vens.getPhone(),
				vens.getShopid(),vens.getShopaddr(),vens.getPermission(),vens.getPass());
		
		Inventory inven=new Inventory(invens.getId(), prod, invens.getQuantity(),ven, invens.getRent());

		Address addr=new Address(ad.getId(), ad.getAddressLine1(), ad.getAddressLine2(), 
				ad.getCity(), ad.getState(), ad.getPostalCode(), cust);
		
		CardDetails card=new CardDetails(cd.getId(), cd.getAadharcard(), cd.getPancard(), cd.getCcno(), cd.getCvv());
		
		Order o=new Order(inven, obj.getRent(), obj.getQuantity(), obj.getBdate(), obj.getRdate(), cust, addr, card);
		custdao.addOrder(o);
		//return cd;
	}
	
	
	@GetMapping("/getaddr/{uid}")
	public List<Address> getAddress(@PathVariable long uid)
	{
		return custdao.getAddr(uid);
		
	}

	

}
