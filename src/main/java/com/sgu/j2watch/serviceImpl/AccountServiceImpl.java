package com.sgu.j2watch.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.AccountRepositoryJPA;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.services.AccountService;
import java.util.regex.Matcher;
import ch.qos.logback.core.joran.conditional.IfAction;

@Component
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountRepositoryJPA accountRepositoryJPA;
	
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
	
	@Override
	public List<Integer> search(String input) {
		Iterable<Account> accountList = accountRepository.findAll();
		List<Integer> newList = new ArrayList<>();
		for(Account acc : accountList) {
			if(acc.getUser_name().equalsIgnoreCase(input) || acc.getPassword().equalsIgnoreCase(input) ) {
				newList.add(acc.getId_account());
			}
			else {
				
			}
		}
		return newList;
    }
	
	@Override
    public UserDetails loadUserByUsername(int id_user) throws UsernameNotFoundException {
		Optional<Account> accOptional = accountRepository.findById(id_user);
		Account account = accOptional.get();
		Optional<User> userOptional = userRepository.findById(account.getUser_id());
		User user = userOptional.get();
//		Iterable<Role> roleIterable = roleRepository.findAll();
		Optional<Role> roleOptional = roleRepository.findById(user.getRole_id());
		Role role = roleOptional.get();
		
        return new org.springframework.security.core.userdetails.User(
				account.getUser_name(), 
				account.getPassword(),
				 Collections.singletonList(new SimpleGrantedAuthority(role.getName().toString())));
    }

//	Collection<GrantedAuthority> grantedAutorAuthorities = new HashSet<>();
//	String role_user  = role.getName();
//	grantedAutorAuthorities.add(new SimpleGrantedAuthority(role_user));
//	System.out.println("---------------------------------");
//
//    System.out.println(role_user);
//	return new CustomUserDetails(account, grantedAutorAuthorities);
	
	@Override
	public boolean checkLogin(int id_user, String password) {
	    try {
	        UserDetails userDetails = loadUserByUsername(id_user);
//	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        System.out.println("---------------------------------");
	        System.out.println(userDetails.getUsername());
	        System.out.println(userDetails.getPassword());
	        System.out.println(userDetails.getAuthorities());

//	        // Kiểm tra mật khẩu
	        if (password.equals(userDetails.getPassword())) {
//	            // Mật khẩu đúng, bạn có thể thực hiện các hành động sau khi đăng nhập thành công
	            return true;
	        } else {
//	            // Mật khẩu không đúng
	            return false;
	        }
	    } catch (UsernameNotFoundException ex) {
//	        // Người dùng không tồn tại
	        return false;
	    }
	}
	
//	@Override
//	public Account findByUser_name(String user_name) {
//		
//		return accountRepositoryJPA.findByUser_name(user_name);
//	}
}
