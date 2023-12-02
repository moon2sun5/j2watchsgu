package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receipt_detail")
public class Receipt_detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receipt_detail")
	private int id_receipt_detail;
	
	@Column(name = "receipt_id")
	private int receipt_id;
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "percent")
	private float percent;

	public Receipt_detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receipt_detail(int id_receipt_detail, int receipt_id, int product_id, int quantity, float price, float percent) {
		super();
		this.id_receipt_detail = id_receipt_detail;
		this.receipt_id = receipt_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.percent = percent;
	}

	public int getId_receipt_detail() {
		return id_receipt_detail;
	}

	public void setId_receipt_detail(int id_receipt_detail) {
		this.id_receipt_detail = id_receipt_detail;
	}

	public int getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	
}
