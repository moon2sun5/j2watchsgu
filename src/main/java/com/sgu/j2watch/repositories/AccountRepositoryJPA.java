package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sgu.j2watch.entities.Account;

public interface AccountRepositoryJPA extends JpaRepository<Account, Integer> {
//	public Account findByUser_name (String user_name);


}
