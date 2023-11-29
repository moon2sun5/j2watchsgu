package com.sgu.j2watch.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bill {
	@Id
	@Column(name = "id_bill")
	private int id;

	@Column(name = "deliver_address")
	private String deliver_address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date create_date;

	@Column(name = "total_price")
	private Float totalPrice;

	@Column(name = "user_id")
	private int user_id;

	@Column(name = "voucher_id")
	private Integer voucher_id;

	@Column(name = "status_bill")
	private int status_id;

	@Column(name = "dienthoai")
	private String dienthoai;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "description_bill", nullable = true)
	private String discription_bill;

	public Bill() {
	}

	public Bill(int id_bill, String deliver_address, Date create_date, Float totalPrice, int user_id, int voucher_id, int status_id, String dienthoai, String fullname, String email, String discription_bill) {
		this.id = id_bill;
		this.deliver_address = deliver_address;
		this.create_date = create_date;
		this.totalPrice = totalPrice;
		this.user_id = user_id;
		this.voucher_id = voucher_id;
		this.status_id = status_id;
		this.dienthoai = dienthoai;
		this.fullname = fullname;
		this.email = email;
		this.discription_bill = discription_bill;
	}

	public int getId_bill() {
		return id;
	}

	public void setId_bill(int id_bill) {
		this.id = id_bill;
	}

	public String getDeliver_address() {
		return deliver_address;
	}

	public void setDeliver_address(String deliver_address) {
		this.deliver_address = deliver_address;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Integer getVoucher_id() {
		return voucher_id;
	}

	public void setVoucher_id(Integer voucher_id) {
		this.voucher_id = voucher_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiscription_bill() {
		return discription_bill;
	}

	public void setDiscription_bill(String discription_bill) {
		this.discription_bill = discription_bill;
	}
}