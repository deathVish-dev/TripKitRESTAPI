package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Controller //mandatory
@RequestMapping("/admin") //optional BUT reco
public class AdminController {
	
	@Autowired
	IProductDao dao;
	
	public AdminController() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	
	@GetMapping("/adminpage")
	public String loadHomePage()
	{
		System.out.println("In admin");
		return "admin/adminhomepage";
	}
	
	
/*	@GetMapping("/add")
	public String addImages() throws FileNotFoundException
	{
		File file=new File("E:\\img.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		//PreparedStatement ps=con.prepareStatement("insert into image_table (name,image) values(?,?)"); 
		//ps.setString(1,"image 1");
		//ps.setBinaryStream(2,fis,(int)file.length());
		
		Product p=new Product(2, "fool", "Smells good", "flower", 1000 , 10, fis.rea);
		dao.addProduct(p);
		return "redirect:/user/userpage";
	}
*/

}
