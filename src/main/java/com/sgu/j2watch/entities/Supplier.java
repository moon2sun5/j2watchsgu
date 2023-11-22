package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Integer id_supplier;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    public Supplier(Integer id_supplier, String name, String address, String phone_number, String email) {
        this.id_supplier = id_supplier;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

	public int getId_supplier() {
		return id_supplier;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId_supplier(Integer id_supplier) {
		this.id_supplier = id_supplier;
	}
    
    // Constructors, getters, setters, and other methods

    // ...
}
