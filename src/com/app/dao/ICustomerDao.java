package com.app.dao;

import com.app.pojos.Customer;

public interface ICustomerDao {

	public Customer getCustomerAcc(String name,String pass);
	public Customer regCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	
	
}
