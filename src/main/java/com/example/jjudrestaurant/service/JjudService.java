package com.example.jjudrestaurant.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.jjudrestaurant.VO.Memberjjud;

public interface JjudService extends UserDetailsService{

	UserDetails loadUserByUsername(String email);
	
	Memberjjud join(Memberjjud user);

}
