package com.abc.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Khachhang {
	@Id
	String makh;
	String ho;
	String ten;
	String diachi;
	String sdt;
	String email;
	int gioitinh;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<Danhgia> listDG;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<Binhluan> listBL;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<Giohang> listGH;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachhang")
	List<Donhang> listDH;
	
	@ManyToOne
	@JoinColumn(name = "matk")
	Taikhoan taikhoan;

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public List<Danhgia> getListDG() {
		return listDG;
	}

	public void setListDG(List<Danhgia> listDG) {
		this.listDG = listDG;
	}

	public List<Binhluan> getListBL() {
		return listBL;
	}

	public void setListBL(List<Binhluan> listBL) {
		this.listBL = listBL;
	}

	public List<Giohang> getListGH() {
		return listGH;
	}

	public void setListGH(List<Giohang> listGH) {
		this.listGH = listGH;
	}

	public List<Donhang> getListDH() {
		return listDH;
	}

	public void setListDH(List<Donhang> listDH) {
		this.listDH = listDH;
	}

	public Taikhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	
	
	
}
