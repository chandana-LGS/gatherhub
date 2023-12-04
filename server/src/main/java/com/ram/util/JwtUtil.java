package com.ram.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secretKey;
	
	// 1. Generate token using subject
	public String generateToken(String subject) {
		return Jwts.builder()
			.setSubject(subject)
			.setIssuer("RGT Company")
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
			.signWith(SignatureAlgorithm.HS256, Base64.getDecoder().decode(secretKey.getBytes()))
			.compact();
	}
	
	//  2. Get Claims
	public Claims getClaims(String token) {
		return Jwts.parser()
			.setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
			.parseClaimsJws(token)
			.getBody();
	}
	
	//  3. read username(subject)
	String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	//  4. Read expire date
	Date getExpireDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	//  5. token epiration check
	boolean isTokenExpired(String token) {
		return getExpireDate(token).before(new Date(System.currentTimeMillis()));
	}
	
	//  6. valid user , token expiration
	boolean validateToken(String token, String username) {
		String tokenUser = getUsername(token);
		// user must be matched and token should not be expire
		return tokenUser.equals(username)&&!isTokenExpired(token);
	}
}
