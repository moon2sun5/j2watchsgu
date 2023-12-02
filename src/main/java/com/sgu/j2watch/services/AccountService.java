package com.sgu.j2watch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
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
	
	public List<Integer> search(String input);
	
	public UserDetails loadUserByUsername(int id_user);
	
	public boolean checkLogin(int id_user, String password);
	
	List<Account> searchNameLogin(String keyName);
	
	
//	Account findByUser_name(String user_name);
}
