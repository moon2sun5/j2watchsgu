package com.sgu.j2watch.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name =  "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "role_id")
	private int role_id;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "reset_password_token")
	private String resetpasswordtoken;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id_user, String name, String address, String phone, String email, int type, int role_id,
			Date birthday, int gender, String resetpasswordtoken) {
		
		this.id_user = id_user;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.role_id = role_id;
		this.birthday = birthday;
		this.gender = gender;
		this.resetpasswordtoken = resetpasswordtoken;
	}


	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getResetpasswordtoken() {
		return resetpasswordtoken;
	}

	public void setResetpasswordtoken(String resetpasswordtoken) {
		this.resetpasswordtoken = resetpasswordtoken;
	}

	

	
}
