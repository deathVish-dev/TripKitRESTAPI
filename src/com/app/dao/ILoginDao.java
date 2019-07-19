package com.app.dao;

import com.app.pojos.Login;

public interface ILoginDao {

	public Login validate(String uname,String pass);
	public String reg(Login l);
}
