package com.midori.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.midori.domain.MemberVO;
import com.midori.mapper.Tbl_memberMapper;
import com.midori.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class AdminUserDetailService implements UserDetailsService {
	
	@Setter(onMethod_ = {@Autowired})
	private Tbl_memberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//사용자의 정보와 권한 정보 등을 담는 타입
		MemberVO vo = mapper.read(username);
		
		log.warn("mapper result : "+vo);
		
		
		return vo == null ? null : new CustomUser(vo); 
	}
}
