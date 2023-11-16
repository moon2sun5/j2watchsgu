package com.sgu.j2watch.entities;

public class Register {
	private User user;
	private Account account;
	
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(User user, Account account) {
		super();
		this.user = user;
		this.account = account;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
