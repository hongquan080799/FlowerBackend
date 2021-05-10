package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Khachhang;
import com.abc.entity.Quyen;
import com.abc.entity.Taikhoan;
import com.abc.model.Dangky;
import com.abc.repository.KhachhangRepository;
import com.abc.repository.TaikhoanRepository;

@RestController
@CrossOrigin
public class DangkyController {

	@Autowired 
	KhachhangRepository khachHangRepo;
	
	@Autowired
	TaikhoanRepository taiKhoanRepo;
	
	@GetMapping("/IsUserExits/{username}")
	public ResponseEntity<Boolean> checkUserExit(@PathVariable("username") String username){
		if(taiKhoanRepo.findByUsername(username) != null)
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Validated @RequestBody Dangky dangky){
		try {
			Khachhang kh = new Khachhang();
			Taikhoan tk = new Taikhoan();
			
			kh.setHo(dangky.getHo());
			kh.setTen(dangky.getTen());
			kh.setGioitinh(dangky.getGioitinh());
			kh.setSdt(dangky.getSdt());
			kh.setEmail(dangky.getEmail());
			kh.setDiachi(dangky.getDiachi());
			String makh = "KH" +  System.currentTimeMillis() % 10000000;
			kh.setMakh(makh);
			
			
			tk.setUsername(dangky.getUsername());
			tk.setPassword(dangky.getPassword());
			tk.setQuyen(new Quyen(2));
			kh.setTaikhoan(tk);
			
			for(Taikhoan t : taiKhoanRepo.findAll()) {
				if(t.getUsername().equalsIgnoreCase(tk.getUsername())) {
					return new ResponseEntity<String>("failed !!!",HttpStatus.BAD_REQUEST);
				}
			}
			taiKhoanRepo.save(tk);
			khachHangRepo.save(kh);
			
			return new ResponseEntity<String>("successed !!!",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("failed !!!",HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/quyen/{username}")
	public int getQuyen(@PathVariable("username") String username) {
		Taikhoan tk = taiKhoanRepo.findByUsername(username);
		return tk.getQuyen().getMaquyen();
	}
}
