package com.sgu.j2watch.entities;

public class ReceiptSupplier {
	private Receipt_detail receipt_detail;
	private Receipt receipt;
	
	public ReceiptSupplier(Receipt_detail receipt_detail, Receipt receipt) {
		super();
		this.receipt_detail = receipt_detail;
		this.receipt = receipt;
	}
	
	public ReceiptSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Receipt_detail getReceipt_detail() {
		return receipt_detail;
	}
	public void setReceipt_detail(Receipt_detail receipt_detail) {
		this.receipt_detail = receipt_detail;
	}
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	
}
