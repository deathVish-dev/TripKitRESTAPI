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

import com.app.dao.IInvenDao;
import com.app.dao.ILoginDao;
import com.app.dao.IProductDao;
import com.app.dao.IVendorDao;
import com.app.pojos.Inventory;
import com.app.pojos.Login;
import com.app.pojos.Product;
import com.app.pojos.Vendor;
import com.app.pojoss.Inventorys;
import com.app.pojoss.Products;
import com.app.pojoss.Vendors;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	IVendorDao vendao;
	@Autowired
	ILoginDao ldao;
	@Autowired
	IProductDao proddao;
	@Autowired
	IInvenDao indao;

	public VendorController() {
	System.out.println("In Vendor Controller");
	}
	
	@GetMapping("/getvendor/{uname}/{pass}")
	public Vendor venDetails(@PathVariable String uname,@PathVariable String pass) {
		Vendor v=vendao.valVendor(uname, pass);
		return v;
	}
	
	@PostMapping("/regvendor")
	public String regVendor(@RequestBody Vendors ven) {
		System.out.println("In Vendor registration");
		Vendor v=new Vendor(ven.getName(), ven.getMail(), ven.getAddr(), ven.getPhone(), 
				ven.getShopid(), ven.getShopaddr(), ven.getPermission(), ven.getPass());
		Login l=new Login(ven.getMail(), ven.getPass(), "Vendor");
		System.out.println(v.toString());
		System.out.println(ldao.reg(l));
		System.out.println(vendao.regVendor(v));
		return "Registered Successfully";
	}
	
	@PostMapping("/updatevendor")
	public String updateVendor(@RequestBody Vendors ven) {
		System.out.println("In update cart");
		System.out.println(ven.toString());
	
		//System.out.println(cart.getQuantity());
		return "Update";
	}
	
	
	@PostMapping("/addinven")
	public String addInven(@RequestBody Inventorys invens) {
		System.out.println("In update cart");
		//System.out.println(invens.toString());
		Products prods=invens.getProd();
		Product prod=new Product(prods.getId(), prods.getName(), prods.getDescription(), prods.getCategory(), prods.getPrice(),
				prods.getRent(), prods.getImg());
		Vendors vens=invens.getVen();
		Vendor ven=new Vendor(vens.getId(),vens.getName(),vens.getMail(),vens.getAddr(),vens.getPhone(),
				vens.getShopid(),vens.getShopaddr(),vens.getPermission(),vens.getPass());
		
		
		Inventory inven=new Inventory(prod, invens.getQuantity(), ven, invens.getRent());
		System.out.println(inven.toString());
		indao.addInventory(inven);
		//System.out.println(cart.getQuantity());*/
		return "Update";
	}
	
	@PostMapping("/updateinven")
	public String updateInven(@RequestBody Inventorys invens) {
		System.out.println("In update Inventory");
		//System.out.println(invens.toString());
		Products prods=invens.getProd();
		Product prod=new Product(prods.getId(), prods.getName(), prods.getDescription(), prods.getCategory(), prods.getPrice(),
				prods.getRent(), prods.getImg());
		Vendors vens=invens.getVen();
		Vendor ven=new Vendor(vens.getId(),vens.getName(),vens.getMail(),vens.getAddr(),vens.getPhone(),
				vens.getShopid(),vens.getShopaddr(),vens.getPermission(),vens.getPass());
		
		
		Inventory inven=new Inventory(invens.getId(),prod, invens.getQuantity(), ven, invens.getRent());
		System.out.println(inven.toString());
		indao.updateInventory(inven);
		//System.out.println(cart.getQuantity());*/
		return "Update";
	}
	
	
	@GetMapping("/getvendormails")
	public ResponseEntity<List<String>> getAllvendorMails() {

		return new ResponseEntity<List<String>>(vendao.getMails(),HttpStatus.OK);
	}
	
	@GetMapping("/getvendorshopid")
	public ResponseEntity<List<String>> getAllVendorShopIds() {

		return new ResponseEntity<List<String>>(vendao.getShopIds(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getinven/{iid}")
	public Inventory getInventory(@PathVariable long iid) {

		return indao.getInventory(iid);
	}
	
	@GetMapping("/invenlist/{vid}")
	public ResponseEntity<List<Inventory>> getVendorInventoryList(@PathVariable long vid) {

		return new ResponseEntity<List<Inventory>>(indao.getVendorInventory(vid),HttpStatus.OK);
	}
	
	@GetMapping("/allinvenlist")
	public ResponseEntity<List<Inventory>> getAllInventoryList() {

		return new ResponseEntity<List<Inventory>>(indao.getAllInventory(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getproductsnotininven/{vid}")
	public ResponseEntity<List<Product>> getAllProductsWhichAreNotInInventory(@PathVariable long vid) {

		return new ResponseEntity<List<Product>>(proddao.getAllProductWhichAreNotInInventory(vid),HttpStatus.OK);
	}
}
