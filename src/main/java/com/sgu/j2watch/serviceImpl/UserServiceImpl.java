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

	@Override
	public boolean updateResetPassword(String token, String email) {
		User user = userRepository.findByEmail(email);

		if(user != null) {
			user.setResetpasswordtoken(token);
			userRepository.save(user);

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public User get(String reset_password_token) {
		return userRepository.findByResetpasswordtoken(reset_password_token);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		Iterable<User> userList = userRepository.findAll();
		Iterable<Account> accountList = accountRepository.findAll();
		for(User userBaby : userList) {
			String userToken = userBaby.getResetpasswordtoken();
			if(userToken != null && userToken.equals(user.getResetpasswordtoken())) {
				int id_user = userBaby.getId_user();
				for(Account acc : accountList) {
					if(acc.getUser_id() == id_user) {
						user.setResetpasswordtoken(null);
						acc.setPassword(newPassword);

						userRepository.save(user);
						accountRepository.save(acc);
					}
				}
			}
		}
	}
}
