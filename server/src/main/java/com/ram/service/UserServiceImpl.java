package com.ram.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.entity.User;
import com.ram.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		/*
		 * String pwd = user.getPwd(); 
		 * pwd = bCryptPasswordEncoder.encode(pwd);
		 * user.setPwd(pwd);
		 */
		user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
		return userRepository.saveAndFlush(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//based on model class username
		User email = userRepository.findByUsername(username);
		//setting roles in the granted authorities
		Set<GrantedAuthority> authorities = new HashSet<>();
		List<String> roles = email.getRoles();
		for(String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		org.springframework.security.core.userdetails.User userSpring = 
				new org.springframework.security.core.userdetails.User(email.getUsername(), email.getPwd(), authorities);
		return userSpring;
	}

}
