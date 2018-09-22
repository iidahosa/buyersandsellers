package com.bns.service.impl;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.models.UserAcc;
import com.bns.models.security.PasswordResetToken;
import com.bns.models.security.UserRole;
import com.bns.repository.PasswordResetTokenRepository;
import com.bns.repository.RoleRepository;
import com.bns.repository.UserRepository;
import com.bns.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}
	
	@Override
	public void createPasswordResetTokenForUser(final UserAcc user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}
	
	@Override
	public UserAcc findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserAcc findByEmail (String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public UserAcc createUser(UserAcc user, Set<UserRole> userRoles){
		UserAcc localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
	
	@Override
	public UserAcc save(UserAcc user) {
		return userRepository.save(user);
	}

}
