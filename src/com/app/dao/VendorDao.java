package com.app.dao;

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
		String jpql="select v from Vendor v where v.name=:name and v.pass=:pass";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class).setParameter(":name", name)
				.setParameter(":pass", pass).getSingleResult();
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

}
