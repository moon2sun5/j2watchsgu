package com.sgu.j2watch.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ChangePassword {
	private Account account;
	private String password2;
	public ChangePassword(Account account, String password2) {
		super();
		this.account = account;
		this.password2 = password2;
	}
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password2 = passwordEncoder.encode(password2);
	}
	
	
}
