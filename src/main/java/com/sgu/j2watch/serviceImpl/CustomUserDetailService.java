package com.sgu.j2watch.serviceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.CustomUserDetails;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.services.AccountService;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		int id_user = accountService.checkAccount(username);
		Optional<Account> accOptional = accountRepository.findById(id_user);
		Account account = accOptional.get();
		Optional<User> userOptional = userRepository.findById(account.getUser_id());
		User user = userOptional.get();
		Optional<Role> roleOptional = roleRepository.findById(user.getRole_id());
		Role role = roleOptional.get();
		
		return new org.springframework.security.core.userdetails.User(
				account.getUser_name(), 
				account.getPassword(),
				 Collections.singletonList(new SimpleGrantedAuthority(role.getName().toString())));

        
	}

}
