package com.sgu.j2watch.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.services.UserService;


@Component
public class UserServiceImpl implements UserService {
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private AccountRepository accountRepository;
	
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public Optional<User> findById(int id_user){
		return userRepository.findById(id_user);
	}
	
	@Override
	public List<User> find(){
		Iterable<User> userList =  userRepository.findAll();
		Iterable<Account> accountList = accountRepository.findAll();
		List<User> suitableUser = new ArrayList<>();
		
		for(User user : userList) {
			boolean found = false;
			for(Account acc : accountList) {
				if(acc.getUser_id() == user.getId_user() ) {
					found = true;
					break;
				}
			}
			
			if (!found) {
		        suitableUser.add(user);
		    }
		}
		
		return suitableUser;
	}
}
