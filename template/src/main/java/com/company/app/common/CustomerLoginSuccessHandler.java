package com.company.app.common;

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
public class CustomerLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleNames = new ArrayList<>();
		authentication.getAuthorities().forEach(
				authority -> {
					roleNames.add(authority.getAuthority());
				});
		
		for (String role : roleNames) {
			System.out.println(role);
		}
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("admin/admin.jsp");
			// response.sendRedirect(request.getContextPath() + "/admin/admin.jsp");
			return;
		} else if (roleNames.contains("ROLE_USER")) {
			response.sendRedirect("user/user.jsp");
			// response.sendRedirect(request.getContextPath() + "/user/user.jsp");
			return;
		}
		response.sendRedirect("/");
	}
}
