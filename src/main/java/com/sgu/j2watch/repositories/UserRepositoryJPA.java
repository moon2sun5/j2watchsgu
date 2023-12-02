package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.User;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Integer>{
	@Query("SELECT user FROM User user WHERE user.name LIKE %?1% OR user.email LIKE %?1%")
	List<User> searchNameOrEmail(String key);
	
	@Query("SELECT user FROM User user WHERE " +
			"(:idType IS NULL OR user.type = :idType) AND " +
	        "(:idRole IS NULL OR user.role_id = :idRole)")
	List<User> searchTypeAndRole(
			@Param("idType") Integer idType,
	        @Param("idRole") Integer idRole);
}
