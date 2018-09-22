package com.bns.service;

import java.util.Set;

import com.bns.models.UserAcc;
import com.bns.models.security.PasswordResetToken;
import com.bns.models.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final UserAcc user, final String token);
	
	UserAcc findByUsername(String username);
	
	UserAcc findByEmail (String email);
	
	UserAcc createUser(UserAcc user, Set<UserRole> userRoles) throws Exception;
	
	UserAcc save(UserAcc user);
}
