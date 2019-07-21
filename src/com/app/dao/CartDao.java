package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Cart;


@Repository
@Transactional
public class CartDao implements ICartDao {

	@Autowired
	SessionFactory sf;
	


	@Override
	public Cart saveInCart(Cart c) {
		Cart cart=null;
		String jpql="select i from Cart i where product_id:=pid and customer_id=:uid";
		System.out.println("in get cart items");
		try{
			cart=sf.getCurrentSession().createQuery(jpql,Cart.class)
			.setParameter("pid", c.getProduct().getId()).setParameter("uid", c.getCustomer().getId()).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(cart==null)
		{
		System.out.println("Cart details********************************************");
		//System.out.println(c.toString());
			sf.getCurrentSession().save(c);
		}
		else
		{
			System.out.println("Else Cart details********************************************");
			//System.out.println(cart.toString());
			cart.setQuantity(cart.getQuantity()+c.getQuantity());
			sf.getCurrentSession().saveOrUpdate(cart);
		}
		return c;
	}



	@Override
	public List<Cart> getUserCart(long uid) {
		List<Cart> cartitems=new ArrayList<Cart>();

		System.out.println("in get cart items");
		String jpql="select i from Cart i where customer_id=:uid";
		try{
			cartitems=sf.getCurrentSession().createQuery(jpql,Cart.class).setParameter("uid", uid).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return cartitems;
	}



	@Override
	public Cart prodCart(long uid, long pid) {
		Cart cart=null;
		String jpql="select i from Cart i where product_id=:pid and customer_id=:uid";
		System.out.println("in get cart items");
		try{
			cart=sf.getCurrentSession().createQuery(jpql,Cart.class)
			.setParameter("pid", pid).setParameter("uid",uid).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			cart=null;
		}
		return cart;
	}

}
