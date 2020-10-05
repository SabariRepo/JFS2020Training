package com.rba.demo.exceptions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSecurityException implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setHeader("WWW-Authentication", "Basic Authentication");
		PrintWriter out = response.getWriter();
		
		out.print("Response Status 403: "+accessDeniedException.getMessage());
		
	}
	
}
