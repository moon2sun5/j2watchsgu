package com.sgu.j2watch.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByResetpasswordtoken(String token);
	
	public User findByEmail(String email);
}
