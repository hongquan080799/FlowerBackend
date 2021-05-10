package com.abc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;

public interface GiohangRepository extends JpaRepository<Giohang, Giohang_ID>{
	
	@Query(nativeQuery = true, value = "select * from giohang where makh = ?1")
	List<Giohang> getGiohangByMakh(String makh);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from giohang where makh = ?1")
	void deleteGiohangByMakh(String username);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from giohang where makh = ?1 and masp = ?2")
	void deleteGiohangByMakhAndMasp(String makh, String masp);
}
