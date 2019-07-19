package com.app.dao;

import java.util.List;

import com.app.pojos.Login;
import com.app.pojos.Product;

public interface IProductDao {
	
	public Product addProduct(Product p);
	public Product updateProduct(Product p);
	public Product getProduct(long id);
	public String removeProduct(Product p);
	public List<Product> getAllProduct();

}
