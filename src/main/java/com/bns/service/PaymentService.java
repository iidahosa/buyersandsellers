package com.bns.service;

import com.bns.models.Payment;
import com.bns.models.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
