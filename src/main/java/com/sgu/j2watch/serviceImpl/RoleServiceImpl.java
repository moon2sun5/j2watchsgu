package com.sgu.j2watch.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.services.RoleService;

@Component
public class RoleServiceImpl implements RoleService {
	@Autowired 
	private RoleRepository roleRepository;
	
	public Iterable<Role> findAll(){
		return roleRepository.findAll();
	}
	
	@Override
	public Optional<Role> findById(int id_role){
		return roleRepository.findById(id_role);
	}
	
	@Override
	public boolean checkQuyen(String name){
		
		Iterable<Role> roleList = roleRepository.findAll();
		
		for(Role role : roleList) {
			if(role.getName().equals(name)) {
				return false;
			}
		}
			
		return true;
	}

}
