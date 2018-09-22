package com.bns.repository;

import org.springframework.data.repository.CrudRepository;

import  com.bns.models.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
