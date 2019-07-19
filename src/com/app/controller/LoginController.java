package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ICustomerDao;
import com.app.dao.ILoginDao;
import com.app.pojos.Login;

@Controller 
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ILoginDao dao;
	@Autowired
	ICustomerDao custdao;
	
	String msg="Enter Email and password";
	
	public LoginController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	
	@GetMapping("/loginpage")
	public String loadLogin(Login l,Model map) {
		System.out.println("in say hello");
		map.addAttribute("msg", msg);
		return "login/logs";
	}
	
	@PostMapping("/loginpage")
	public String processLogin(String mail,String password,HttpSession session) {
		System.out.println("in say process login\n"+mail+" "+password);
		Login login=null;
		login=dao.validate(mail,password);
		System.out.println(login);
		if(login!=null) 
		{
			//session.setAttribute("loginuser", login);
			msg="Enter Email and password";
			String role=login.getRole();
			if(role.equals("Admin"))
			{
				return "redirect:/admin/adminpage";
			}
			else if(role.equals("Customer"))
			{
				session.setAttribute("useracc",custdao.getCustomerAcc(mail, password) );
			return "redirect:/user/userpage";
			}
			else
			return "redirect:/vendor/vendorpage";
		}
		else
		{
			msg="Wrong credentials";
			System.out.println(msg);
			return "redirect:/login/loginpage";
		}
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
