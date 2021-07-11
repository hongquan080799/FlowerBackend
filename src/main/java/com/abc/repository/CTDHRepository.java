package com.abc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.abc.entity.CTDH;
import com.abc.entity.CTDH_ID;
import com.abc.model.Thongke;

public interface CTDHRepository extends JpaRepository<CTDH, CTDH_ID>{
	
	@Query(nativeQuery = true, value = "select * from ctdh where madh =?1")
	List<CTDH> getCTDHByMadh(String madh);

	@Query(nativeQuery = true, value = "select * from ctdh where madh =?1")
	List<CTDH> postCTDHByMadh(String madh);
	
	@Query(nativeQuery = true, value = "delete from ctdh where madh=?1")
	List<CTDH> deleteCTDHByDonhang(String madh);
	
}
