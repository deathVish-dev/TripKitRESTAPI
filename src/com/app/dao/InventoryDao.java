package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Cart;
import com.app.pojos.Inventory;
import com.app.pojos.Product;


@Repository
@Transactional
public class InventoryDao implements IInvenDao {

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public List<Inventory> getVendorInventory(long id) {
		List<Inventory> invens=new ArrayList<Inventory>();

		System.out.println("in get inventory");
		String jpql="select i from Inventory i where ven_id=:vid";
		invens=sf.getCurrentSession().createQuery(jpql,Inventory.class).setParameter("vid", id).getResultList();
		return invens;
	}

	@Override
	public Inventory addInventory(Inventory inven) {
		/*Inventory in;
		String jpql="select i from Inventory i where ven_id=:vid and product_id=:pid";
		try{
			in=sf.getCurrentSession().createQuery(jpql,Inventory.class).setParameter("vid", inven.getVen().getId())
					.setParameter("pid", inven.getProd().getId()).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			in=null;
		}
		*/
		sf.getCurrentSession().save(inven);
		return inven;
	}

	@Override
	public Inventory updateInventory(Inventory inven) {
		sf.getCurrentSession().saveOrUpdate(inven);
		return inven;
	}

	@Override
	public Inventory getInventory(long id) {
		return sf.getCurrentSession().get(Inventory.class, id);
	}

	@Override
	public String removeInventory(Inventory inven) {
		sf.getCurrentSession().remove(inven);
		return "Successful";
	}

}
