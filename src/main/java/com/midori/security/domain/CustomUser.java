package com.midori.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.midori.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	
	private MemberVO member;
	
	public CustomUser(String username, String password,	Collection<? extends GrantedAuthority> authorities) {
			super(username, password, authorities); //User클래스를 상속하기 때문에 부모 클래스 생성자를 호출해야 한다
			}
	
	public CustomUser(MemberVO vo) {
		super(vo.getId(), vo.getPwd(), 
				vo.getAuthList().stream().map(auth -> 
				new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
				//Tbl_autuVO 인스턴스는 GrantedAuthority 객체로 변환해야 하므로 stream() 과 map()을 이용해서 처리한다
				this.member = vo;
	}
	
}
