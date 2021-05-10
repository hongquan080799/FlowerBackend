package com.abc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Giohang_ID implements Serializable{
	String makh;
	String masp;
	
	
	
	public Giohang_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Giohang_ID(String makh, String masp) {
		super();
		this.makh = makh;
		this.masp = masp;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	
	
}
