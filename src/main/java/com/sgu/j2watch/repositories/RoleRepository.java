package com.sgu.j2watch.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

	

}
