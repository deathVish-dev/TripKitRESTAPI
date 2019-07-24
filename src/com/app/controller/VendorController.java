package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILoginDao;
import com.app.dao.IVendorDao;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Vendor;
import com.app.pojoss.Customers;
import com.app.pojoss.Vendors;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	IVendorDao vendao;
	@Autowired
	ILoginDao ldao;

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
		//System.out.println(vendao.regVendor(v));
		//ldao.reg(l);
		return "Registered Successfully";
	}
	
	@PostMapping("/updatevendor")
	public String updateVendor(@RequestBody Vendors ven) {
		System.out.println("In update cart");
		System.out.println(ven.toString());
	
		//System.out.println(cart.getQuantity());
		return "Update";
	}
}
