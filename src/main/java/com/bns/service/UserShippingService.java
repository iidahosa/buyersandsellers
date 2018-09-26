package com.bns.service;

import java.util.Optional;

import com.bns.models.*;

public interface UserShippingService {
	Optional<UserShipping> findById(Long id);
	
	void removeById(Long id);
}
