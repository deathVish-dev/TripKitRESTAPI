package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.Vendor;


@Repository
@Transactional
public class VendorDao implements IVendorDao {

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public Vendor valVendor(String name, String pass) {
		System.out.println("In Validate Vendor");
		String jpql="select v from Vendor v where v.mail=:name and v.pass=:pass";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class).setParameter("name", name)
				.setParameter("pass", pass).getSingleResult();
	}

	@Override
	public Vendor regVendor(Vendor v) {
		sf.getCurrentSession().save(v);
		return v;
	}

	@Override
	public Vendor updateVendor(Vendor v) {
		sf.getCurrentSession().update(v);
		return v;
	}

	@Override
	public List<String> getMails() {
			String jpql="select c.mail from Vendor c";
			List<String> mailist=null;
			try{
				sf.getCurrentSession().createQuery(jpql,String.class).getResultList();
			}catch (Exception e) {
				// TODO: handle exception
				mailist=null;
			}
			
			System.out.println(mailist);
			return mailist;
		}
	@Override
	public List<String> getShopIds() {
		String jpql="select c.shopid from Vendor c";
		List<String> idlist=null;
		try{
			sf.getCurrentSession().createQuery(jpql,String.class).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			idlist=null;
		}
		
		System.out.println(idlist);
		return idlist;
	}
	

}
