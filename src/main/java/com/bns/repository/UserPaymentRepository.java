package com.bns.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.models.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{

}
