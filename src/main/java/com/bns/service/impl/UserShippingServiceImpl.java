package com.bns.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.models.UserShipping;
import com.bns.repository.UserShippingRepository;
import com.bns.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	
	public Optional<UserShipping> findById(Long id) {
		return userShippingRepository.findById(id);
	}
	
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}

}
