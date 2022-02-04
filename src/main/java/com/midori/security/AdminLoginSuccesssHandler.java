package com.midori.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminLoginSuccesssHandler implements AuthenticationSuccessHandler {
	// 회원가입한 계정으로 로그인 했을때 인텍스 페이지로 이동, 관리자 계정으로 로그인 했을때 /adm/adminmanager 로 이동

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.info("login success");
		
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/adm/admin");
			return;
		}
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/");
			return;
		}
		response.sendRedirect("/");
	}

}
