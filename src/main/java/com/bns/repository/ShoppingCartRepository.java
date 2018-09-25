package com.bns.repository;

import org.springframework.data.repository.CrudRepository;

import com.bns.models.*;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
