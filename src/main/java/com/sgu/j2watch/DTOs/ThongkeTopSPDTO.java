package com.sgu.j2watch.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class ThongkeTopSPDTO {

	private int id_product;
	private String name;
	private Long quantity;

	
	public ThongkeTopSPDTO(int id_product,String name, Long quantity) {
		
		this.id_product = id_product;
		this.name = name;
		this.quantity = quantity;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
