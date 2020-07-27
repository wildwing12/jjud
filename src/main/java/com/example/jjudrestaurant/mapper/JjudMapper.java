package com.example.jjudrestaurant.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.jjudrestaurant.VO.Memberjjud;

@Repository
@Mapper
public interface JjudMapper {

	Memberjjud loadUserByUsername(String username);

	
}
