package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	
	public Vendor valVendor(String name,String pass);
	public Vendor regVendor(Vendor v);
	public Vendor updateVendor(Vendor v);
	public List<String> getMails();
	List<String> getShopIds();

}
