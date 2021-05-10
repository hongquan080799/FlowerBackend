package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Khachhang;
import com.abc.entity.Taikhoan;
import com.abc.model.Dangky;
import com.abc.repository.KhachhangRepository;
import com.abc.repository.TaikhoanRepository;

@RestController
@CrossOrigin
public class KhachhangController {
	
	@Autowired
	KhachhangRepository repo;
	
	@Autowired
	TaikhoanRepository tkRepo;
	
	@GetMapping("/khachhang/{username}")
	public Khachhang getKhachHang(@PathVariable("username") String username) {
		return repo.getKhachHangByUsername(username); 
	}
	
	@GetMapping("/khachhang")
	public List<Khachhang> getListKH(){
		return repo.findAll();
	}
	
	@PutMapping("/khachhang")
	public ResponseEntity<Boolean> updateKhachhang(@Validated @RequestBody Dangky dk){
		Khachhang kh = repo.getKhachHangByUsername(dk.getUsername());
		Taikhoan tk = tkRepo.findByUsername(dk.getUsername());
		
		tk.setUsername(dk.getUsername());
		tk.setPassword(dk.getPassword());
		
		kh.setHo(dk.getHo());
		kh.setTen(dk.getTen());
		kh.setGioitinh(dk.getGioitinh());
		kh.setDiachi(dk.getDiachi());
		kh.setEmail(kh.getEmail());
		kh.setSdt(dk.getSdt());
		kh.setTaikhoan(tk);
		
		try {
			tkRepo.save(tk);
			repo.save(kh);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/khachhang/{matk}")
	public ResponseEntity<Boolean> deleteKH(@PathVariable("matk") int matk){
		try {
			repo.deleteKhachHangByMatk(matk);
			tkRepo.deleteById(matk);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
			
		}
	}
}
