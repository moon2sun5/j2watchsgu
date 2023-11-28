package com.sgu.j2watch.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {
	public UserDetails loadUserByUsername(String username);
}
