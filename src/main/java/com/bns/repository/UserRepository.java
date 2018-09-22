package com.bns.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.models.UserAcc;

public interface UserRepository extends CrudRepository<UserAcc, Long> {
	UserAcc findByUsername(String username);
	
	UserAcc findByEmail(String email);
}
