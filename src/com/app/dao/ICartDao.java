package com.app.dao;

import java.util.List;

import com.app.pojos.Cart;

public interface ICartDao {
	
	public List<Cart> getUserCart(long uid);
	public Cart saveInCart(Cart c);
	public Cart prodCart(long uid,long pid);

}
