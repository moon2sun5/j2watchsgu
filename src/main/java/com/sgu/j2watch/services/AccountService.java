package com.sgu.j2watch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Account;

@Service
public interface AccountService {
	public Iterable<Account> findAll();
	
	public Optional<Account> findById(int id_account);
	
	public boolean checkUsername(String name);
	
	public boolean checkUsernameEdit(String name, int id);
	
	public int checkAccount(String name);
	
	public boolean checkPassword(String pass);
}
