package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;


@Repository
@Transactional
public class CustomerDao implements ICustomerDao {

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public Customer getCustomerAcc(String name, String pass) {
		
		String jpql="select c from Customer c where c.mail=:name and c.pass=:pass";
		return sf.getCurrentSession().createQuery(jpql,Customer.class).setParameter("name", name)
				.setParameter("pass", pass).getSingleResult();
	}

	@Override
	public Customer regCustomer(Customer c) {
		sf.getCurrentSession().save(c);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		sf.getCurrentSession().update(c);
		return c;
	}
	

}
