package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICustomerDao;
import com.app.dao.ILoginDao;
import com.app.dao.IVendorDao;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Vendor;

@CrossOrigin/*(origins = "http://localhost:4200")*/
@RestController 
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ILoginDao dao;
	@Autowired
	ICustomerDao custdao;
	@Autowired
	IVendorDao vendao;
	
	String msg="Enter Email and password";
	
	public LoginController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	
	@GetMapping("/logindtls/{uname}/{pass}")
	public Login loadLogin(@PathVariable String uname,@PathVariable String pass) {
		Login login=null;
		login=dao.validate(uname,pass);
		System.out.println(login);
		return login;
		}
	@GetMapping("/custdtls/{uname}/{pass}")
	public Customer custDetails(@PathVariable String uname,@PathVariable String pass) {
		Customer c=custdao.getCustomerAcc(uname, pass);
		return c;
		}
	
	@GetMapping("/vendtls/{uname}/{pass}")
	public Vendor venDetails(@PathVariable String uname,@PathVariable String pass) {
		Vendor v=vendao.valVendor(uname, pass);
		return v;
		}
	
	
	@GetMapping("/logindtlsforsession/{login}")
	public String processLogin(@PathVariable Login l) {
		System.out.println("in say process login\n");
			//session.setAttribute("loginuser", login);
			msg="Enter Email and password";
			String role=l.getRole();
			if(role.equals("Admin"))
			{
				return "redirect:/admin/adminpage";
			}
			else if(role.equals("Customer"))
			{
				//session.setAttribute("useracc",custdao.getCustomerAcc(mail, password) );
			return "redirect:/user/userpage";
			}
			else
			return "redirect:/vendor/vendorpage";
	}
	
	@GetMapping("/regchoice")
	public String loadregchoice() {
		System.out.println("in registration choice");
		return "login/regchoice";
	}
	
	
	@GetMapping("/registration")
	public String loadreg() {
		System.out.println("in registration");
		return "login/registration";
	}

}
