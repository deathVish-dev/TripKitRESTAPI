package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.CardDetails;
import com.app.pojos.Customer;
import com.app.pojos.Order;


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

	@Override
	public List<String> getMails() {
		String jpql="select c.mail from Customer c";
		return sf.getCurrentSession().createQuery(jpql,String.class).getResultList();
	}

	@Override
	public List<Address> getAddr(long uid) {
		String jpql="select a from Address a where customer_id=:uid";
		return sf.getCurrentSession().createQuery(jpql,Address.class).setParameter("uid", uid).getResultList();
	}

	@Override
	public Address addAddr(Address addr) {
		sf.getCurrentSession().save(addr);
		return addr;
	}

	@Override
	public Address updateAddr(Address addr) {
		sf.getCurrentSession().saveOrUpdate(addr);
		return addr;
	}

	@Override
	public Address getAddrById(long aid) {
		return sf.getCurrentSession().get(Address.class, aid);
	}

	@Override
	public CardDetails addCard(CardDetails cd) {
		sf.getCurrentSession().save(cd);
		return cd;
	}

	@Override
	public Order addOrder(Order o) {
		sf.getCurrentSession().save(o);
		return o;
	}
	
	
	
	
	

}
