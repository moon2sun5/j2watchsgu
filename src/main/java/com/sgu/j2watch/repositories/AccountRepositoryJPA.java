package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.Account;

@Repository
public interface AccountRepositoryJPA extends JpaRepository<Account, Integer> {
//	public Account findByUser_name (String user_name);
	@Query("SELECT acc FROM Account acc WHERE acc.user_name LIKE %?1%")
	List<Account> searchNameLogin(String keyName);

}
