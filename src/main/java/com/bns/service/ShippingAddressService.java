package com.bns.service;

import com.bns.models.ShippingAddress;
import com.bns.models.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
