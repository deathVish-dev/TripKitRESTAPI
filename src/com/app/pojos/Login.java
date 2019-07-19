package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "LoginTable")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "login_id")
    private Long id;
	
	@Column(name = "uname")
	private String uname;
	
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "role")
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
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(Long id, String uname, String pass, String role) {
		super();
		this.id = id;
		this.uname = uname;
		this.pass = pass;
		this.role = role;
	}

	public Login(String uname, String pass, String role) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.role = role;
	}
	
	

}
