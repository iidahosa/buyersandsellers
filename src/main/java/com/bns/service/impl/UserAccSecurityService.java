package com.bns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bns.models.UserAcc;
import com.bns.repository.UserAccRepository;

@Service
public class UserAccSecurityService implements UserDetailsService{
	
	@Autowired
	private UserAccRepository userAccRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAcc userAcc = userAccRepository.findByUsername(username);
		
		if(null == userAcc) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		return userAcc;
	}

}
