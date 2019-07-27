package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.CardDetails;
import com.app.pojos.Customer;
import com.app.pojos.Order;

public interface ICustomerDao {

	public Customer getCustomerAcc(String name,String pass);
	public Customer regCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	public List<String> getMails();
	public List<Address> getAddr(long uid);
	public Address addAddr(Address addr);
	public Address updateAddr(Address addr);
	public Address getAddrById(long aid);
	public CardDetails addCard(CardDetails cd);
	
	public Order addOrder(Order o);
}
