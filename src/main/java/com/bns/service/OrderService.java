package com.bns.service;

import java.util.Optional;

import com.bns.models.BillingAddress;
import com.bns.models.Order;
import com.bns.models.Payment;
import com.bns.models.ShippingAddress;
import com.bns.models.ShoppingCart;
import com.bns.models.UserAcc;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			UserAcc userAcc);
	
	Optional<Order> findOne(Long id);
}

