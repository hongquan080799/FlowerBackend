package com.abc.jwt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abc.entity.Taikhoan;
import com.abc.repository.TaikhoanRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	TaikhoanRepository repo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       Taikhoan taikhoan;
       taikhoan = repo.findByUsername(s);
       if(taikhoan == null) throw new UsernameNotFoundException(s);
       return new UserPrinciple(taikhoan);
    }
}