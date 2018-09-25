package com.bns.service;

import com.bns.models.*;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
