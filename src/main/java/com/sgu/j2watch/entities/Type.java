package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "type")
@Entity
public class Type {
	@Id
	@Column(name = "id_type")
	private int id_type;
	
	@Column(name = "name")
	private String name;
	
	

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int id_type, String name) {
		
		this.id_type = id_type;
		this.name = name;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
