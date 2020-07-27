package com.example.jjudrestaurant.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jjudrestaurant.VO.Memberjjud;
import com.example.jjudrestaurant.mapper.JjudMapper;
import com.example.jjudrestaurant.provider.JwtTokenProvider;
import com.example.jjudrestaurant.service.JjudService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class JjudController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	@Autowired
    private JjudService service;
	@Autowired
	private JjudMapper mapper;
	
	// 회원가입
    @PostMapping("/join")
    public void join(@RequestBody Memberjjud user) {
        Memberjjud memberJjud = service.join(user);
    }
    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
		
    	log.info("쥬쥬쥬ㅠ쥽베베베:{}",user);
    	Memberjjud member =  (Memberjjud) service.loadUserByUsername(user.get("email"));
    			//(Memberjjud) userDetailService.loadUserByUsername(user.get("email"));
    	if("".equals(member.getEmail())||member.getEmail()==null) {
    		throw new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
    	}
		/*
		 * if(!passwordEncoder.matches(user.get("password"), member.getPassword())) {
		 * throw new IllegalArgumentException("잘못된 비밀번호입니다."); }
		 */
   
		  return jwtTokenProvider.createToken(member.getUsername(), member.getUserRole());
		 
    }
}
