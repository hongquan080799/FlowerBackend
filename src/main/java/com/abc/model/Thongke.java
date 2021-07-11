package com.abc.model;

import com.abc.entity.Sanpham;

public class Thongke {
	String masp;
	String tensp;
	int soluong;
	
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
//	public Sanpham getSp() {
//		return sp;
//	}
//	public void setSp(Sanpham sp) {
//		this.sp = sp;
//	}
	
	public int getSoluong() {
		return soluong;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
