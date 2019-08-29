package com.jsplec.bss.dto;

public class SDto {

	int sSeqno;
	String sName;
	String sTelno;
	String sAddress;
	String sEmail;
	String sRelation;
	
	public SDto() {
		// TODO Auto-generated constructor stub
	}

	public SDto(int sSeqno, String sName, String sTelno, String sAddress, String sEmail, String sRelation) {
		super();
		this.sSeqno = sSeqno;
		this.sName = sName;
		this.sTelno = sTelno;
		this.sAddress = sAddress;
		this.sEmail = sEmail;
		this.sRelation = sRelation;
	}

	public int getsSeqno() {
		return sSeqno;
	}

	public void setsSeqno(int sSeqno) {
		this.sSeqno = sSeqno;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsTelno() {
		return sTelno;
	}

	public void setsTelno(String sTelno) {
		this.sTelno = sTelno;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsRelation() {
		return sRelation;
	}

	public void setsRelation(String sRelation) {
		this.sRelation = sRelation;
	}


	
	
	
}
