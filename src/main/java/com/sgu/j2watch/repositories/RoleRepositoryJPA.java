package com.sgu.j2watch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgu.j2watch.entities.Role;

public interface RoleRepositoryJPA extends JpaRepository<Role, Integer> {
//	Role findByRole (String name);
}
