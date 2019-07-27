package com.app.pojoss;

public class CardDtls {
	
	private long id;
	private long aadharcard;
	private String pancard;
	private long ccno;
	private int cvv;
	
	public CardDtls() {
		// TODO Auto-generated constructor stub
	}

	public CardDtls(long id, long aadharcard, String pancard, long ccno, int cvv) {
		super();
		this.id = id;
		this.aadharcard = aadharcard;
		this.pancard = pancard;
		this.ccno = ccno;
		this.cvv = cvv;
	}

	public CardDtls(long aadharcard, String pancard, long ccno, int cvv) {
		super();
		this.aadharcard = aadharcard;
		this.pancard = pancard;
		this.ccno = ccno;
		this.cvv = cvv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(long aadharcard) {
		this.aadharcard = aadharcard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getCcno() {
		return ccno;
	}

	public void setCcno(long ccno) {
		this.ccno = ccno;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CardDtls [id=" + id + ", aadharcard=" + aadharcard + ", pancard=" + pancard + ", ccno=" + ccno
				+ ", cvv=" + cvv + "]";
	}
	
	

}
