package com.abc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DanhGia_ID implements Serializable{
	String makh;
	String masp;
	public String getMand() {
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
