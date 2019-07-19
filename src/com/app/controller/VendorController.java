package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	public VendorController() {
	System.out.println("In Vendor");
	}
	
	@GetMapping("/vendorpage")
	public String loadHomePage()
	{
		return "vendor/vendorhomepage";
	}
}
