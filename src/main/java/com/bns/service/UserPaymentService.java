package com.bns.service;

import java.util.Optional;

import com.bns.models.UserPayment;

public interface UserPaymentService {
	Optional<UserPayment> findById(Long id);
	
	void removeById(Long id);
}
