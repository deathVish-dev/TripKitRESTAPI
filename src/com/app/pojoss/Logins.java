package com.app.pojoss;

import javax.persistence.*;


public class Logins {
	

    private Long id;
	
	
	private String uname;
	
	private String pass;
	
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Logins() {
		// TODO Auto-generated constructor stub
	}

	public Logins(Long id, String uname, String pass, String role) {
		super();
		this.id = id;
		this.uname = uname;
		this.pass = pass;
		this.role = role;
	}

	public Logins(String uname, String pass, String role) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.role = role;
	}
	
	

}
