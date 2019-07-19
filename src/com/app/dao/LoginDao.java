package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Login;


@Repository
@Transactional
public class LoginDao implements ILoginDao {

	
	@Autowired
	SessionFactory sf;
	
	
	@Override
	public Login validate(String uname, String pass) {
		String jpql="select c from Login c where c.uname=:uname and c.pass=:pass";
		System.out.println("in validate dao");
		Login l=null;
		try{
			l=sf.getCurrentSession().createQuery(jpql,Login.class).setParameter("uname", uname).setParameter("pass", pass).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			l=null;
		}
			return l;			
		
	}

	@Override
	public String reg(Login l) {
		
		return null;
	}

}
