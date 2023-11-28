package com.sgu.j2watch.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;

import com.sgu.j2watch.services.AccountService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Component
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}
	
	@Override
	public Optional<Account> findById(int id_account){
		return accountRepository.findById(id_account);
	}
	
	@Override
	public boolean checkUsername(String name){
		
		Iterable<Account> accountList = accountRepository.findAll();
		
		for(Account acc : accountList) {
			if(acc.getUser_name().equals(name)) {
				return false;
			}
		}
			
		return true;
	}
	@Override
	public boolean checkUsernameEdit(String name, int id){
		
		Iterable<Account> accountList = accountRepository.findAll();
		
		for(Account acc : accountList) {
			if(acc.getUser_id() != id && acc.getUser_name().equals(name)) {
				return false;
			}
		}
			
		return true;
	}
	
	@Override
	public int checkAccount(String name){
		
		Iterable<Account> accountList = accountRepository.findAll();
		
		for(Account acc : accountList) {
			if(acc.getUser_name().equals(name)) {
				return acc.getId_account();
			}
		}
		return -1;
	}
	
	@Override
	public boolean checkPassword(String pass){
		
		Iterable<Account> accountList = accountRepository.findAll();
		
		for(Account acc : accountList) {
			if(acc.getPassword().equals(pass)) {
				return false;
			}
		}
			
		return true;
	}
}
