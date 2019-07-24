package com.app.dao;

import java.util.List;

import com.app.pojos.Inventory;


public interface IInvenDao {

	public List<Inventory> getVendorInventory(long id);
	public Inventory addInventory(Inventory inven);
	public Inventory updateInventory(Inventory inven);
	public Inventory getInventory(long id);
	public String removeInventory(Inventory inven);
}
