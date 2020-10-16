package com.ufes.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufes.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
Role findByName(String name);

}
