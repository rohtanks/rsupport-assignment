package com.roh.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roh.domain.MemberVo;
import com.roh.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void regist(MemberVo vo) throws Exception {
		vo.setUserpw(passwordEncoder.encode(vo.getUserpw()));
		mapper.create(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo account = mapper.findByUserid(username);

		// UserDetails 타입으로 변환
		UserDetails userDetails = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return account.getUserid();
			}
			
			@Override
			public String getPassword() {
				return account.getUserpw();
			}
			
			/**
			 * 권한을 담는 객체
			 * 임의로 ROLE_USER 권한을 반환
			 */
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				return authorities;
			}
		};
		
		return userDetails;
	}
	
}