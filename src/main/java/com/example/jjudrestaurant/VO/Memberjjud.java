package com.example.jjudrestaurant.VO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class Memberjjud implements UserDetails {
	private int id; 
	private String email;
	private String password; 
	private  List<String> userRole=new ArrayList<>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userRole.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	} 
	public Memberjjud() {}
}
