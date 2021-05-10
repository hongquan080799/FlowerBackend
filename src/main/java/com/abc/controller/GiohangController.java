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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Danhmuc;
import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;
import com.abc.entity.Khachhang;
import com.abc.entity.Sanpham;
import com.abc.entity.Taikhoan;
import com.abc.repository.GiohangRepository;

@RestController
@CrossOrigin
public class GiohangController {
	@Autowired
	GiohangRepository repo;
	
	@GetMapping("/giohang/{makh}")
	public List<Giohang> getListGH(@PathVariable("makh") String makh){
		return repo.getGiohangByMakh(makh);
	}
	
	@GetMapping("/giohang/{makh}/{masp}")
	public ResponseEntity<Boolean> changeNum(@PathVariable("makh") String makh,@PathVariable("masp") String masp,@RequestParam("soluong") int soluong) {
		List<Giohang> listGH = repo.getGiohangByMakh(makh);
		for(Giohang gh:listGH) {
			if(gh.getSanpham().getMasp().equalsIgnoreCase(masp)) {
				Giohang giohang = gh;
				giohang.setSoluong(soluong);
				//System.out.println(gh.getKhachhang().getTen());
				try {
					repo.save(giohang);
					return new ResponseEntity<Boolean>(true,HttpStatus.OK);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
			}
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_GATEWAY);
	}
	
	
	@PostMapping("/giohang/{makh}/{masp}")
	public String addCart(@PathVariable("makh") String makh, @PathVariable("masp") String masp,@RequestParam("soluong") int soluong) {
		Giohang_ID id = new Giohang_ID(makh, masp);
		Giohang gh = new Giohang();
		gh.setId(id);
		gh.setSoluong(soluong);
		Sanpham sp = new Sanpham();
		sp.setMasp(masp);
		Khachhang kh = new Khachhang();
		kh.setMakh(makh);
		gh.setSanpham(sp);
		gh.setKhachhang(kh);
		
		List<Giohang> listGH = repo.findAll();
		for(Giohang i:listGH) {
			if(i.getId().getMasp().equalsIgnoreCase(masp) && i.getId().getMakh().equalsIgnoreCase(makh)) {
				gh.setSoluong(soluong +i.getSoluong());
			}
		}
		try {
			repo.save(gh);
			return "true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	@DeleteMapping("/giohang/{makh}")
	public ResponseEntity<String> deleteGiohangOfKhachhang(@PathVariable("makh") String makh) {
		try {
			repo.deleteGiohangByMakh(makh);
			return new ResponseEntity<String>("Successed !!!",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Failed !!!",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/giohang/{makh}/{masp}")
	public ResponseEntity<String> deleteGiohangById(@PathVariable("makh") String makh, @PathVariable("masp") String masp) {
		try {
			repo.deleteGiohangByMakhAndMasp(makh, masp);
			return new ResponseEntity<String>("Successed !!!",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Failed !!!",HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/numcart/{makh}")
	public int getSLC(@PathVariable("makh") String makh) {
		List<Giohang> list = repo.getGiohangByMakh(makh);
		int soluong = 0 ;
		for(Giohang gh:list) {
			soluong +=gh.getSoluong();
		}
		return soluong;
	}
	
}
