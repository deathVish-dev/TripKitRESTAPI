package com.app.dao;

import java.io.*;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Inventory;
import com.app.pojos.Login;
import com.app.pojos.Product;
import com.mysql.jdbc.PreparedStatement;

@Repository
@Transactional
public class ProductDao implements IProductDao {

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public Product addProduct(Product p) {
		sf.getCurrentSession().save(p);
		return p;
	}

	@Override
	public Product updateProduct(Product p) {
		sf.getCurrentSession().saveOrUpdate(p);
		return p;
	}

	@Override
	public Product getProduct(long id) {
		return sf.getCurrentSession().get(Product.class, id);
	}

	@Override
	public String removeProduct(Product p) {
		sf.getCurrentSession().remove(p);
		return "Successful";
	}

	@Override
	public List<Product> getAllProduct() {
		String jpql="select c from Product c";
		System.out.println("in validate dao");
		List<Product> l=null;
		try{
			l=sf.getCurrentSession().createQuery(jpql,Product.class).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			l=null;
		}
			return l;
	}
	
	@Override
	public List<Product> getAllProductWhichAreNotInInventory(long id) {
		String inven="select prod from Inventory i where ven_id=:vid";
		List<Product> pids=null;
		try{
			pids=sf.getCurrentSession().createQuery(inven,Product.class).setParameter("vid", id).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			pids=null;
		}
		//System.out.println(pids.get(0).getName());
		String jpql="select c from Product c where product_id not in (:pids)";
		System.out.println("in validate dao");
		List<Product> l=null;
		try{
			l=sf.getCurrentSession().createQuery(jpql,Product.class).setParameter("pids", pids).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			l=null;
		}
			return l;
	}
	
	
	

}
