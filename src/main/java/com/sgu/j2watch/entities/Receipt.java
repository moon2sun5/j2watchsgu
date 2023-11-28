package com.sgu.j2watch.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receipt")
	private int id_receipt;
	
	@Column(name = "create_date")
	private Date create_date;
	
	@Column(name = "supplier_id")
	private int supplier_id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "total")
	private float total;

	public Receipt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receipt(int id_receipt, Date create_date, int supplier_id, int user_id, float total) {
		super();
		this.id_receipt = id_receipt;
		this.create_date = create_date;
		this.supplier_id = supplier_id;
		this.user_id = user_id;
		this.total = total;
	}

	public int getId_receipt() {
		return id_receipt;
	}

	public void setId_receipt(int id_receipt) {
		this.id_receipt = id_receipt;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
