package com.roh.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.roh.domain.MemberVo;

public interface MemberService extends UserDetailsService {

	public void regist(MemberVo vo) throws Exception;
	
}
