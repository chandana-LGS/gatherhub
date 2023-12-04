package com.ram.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class InvalidAuthenticationEntryPoint implements AuthenticationEntryPoint{

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//response send error
		//response.sendError(401, "Un-Authorized");    or   down one we can use
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid user ! Please check data");
	}
	
}
