package com.sgu.j2watch.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Role;

@Service
public interface RoleService {
	public Iterable<Role> findAll();
	
	public Optional<Role> findById(int id_role);
	
	public boolean checkQuyen(String name);
	
}
