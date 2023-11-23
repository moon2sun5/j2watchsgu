package com.sgu.j2watch.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class ThongKeTopNhanVienDTO {
	private int user_id;
	private int type;
	private String name;
	private Double total_sale;
	public ThongKeTopNhanVienDTO(int user_id, int type, String name, Double total_sale) {
		
		this.user_id = user_id;
		this.type = type;
		this.name = name;
		this.total_sale = total_sale;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getTotal_sale() {
		return total_sale;
	}
	public void setTotal_sale(Double total_sale) {
		this.total_sale = total_sale;
	}
	
}
