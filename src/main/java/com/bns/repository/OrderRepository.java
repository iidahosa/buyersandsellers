package com.bns.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.models.*;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
