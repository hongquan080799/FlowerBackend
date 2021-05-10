package com.abc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Khachhang;

public interface KhachhangRepository extends JpaRepository<Khachhang, String>{

	@Query(value="select kh from Khachhang kh where kh.taikhoan.username = ?1")
	Khachhang getKhachHangByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value="delete from Khachhang kh where kh.taikhoan.matk = ?1")
	void deleteKhachHangByMatk(int matk);
}
