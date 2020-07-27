package com.example.jjudrestaurant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.jjudrestaurant.VO.Memberjjud;
import com.example.jjudrestaurant.mapper.JjudMapper;
import com.example.jjudrestaurant.service.JjudService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class JjudeServiceImpl implements  JjudService {

	@Autowired
	JjudMapper mapper;
	
	

	@Override
	public Memberjjud join(Memberjjud user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserDetails loadUserByUsername(String email) {
		Memberjjud member = mapper.loadUserByUsername(email);//데이터 베이스에서 정보 출력
        return member;
	}

}
