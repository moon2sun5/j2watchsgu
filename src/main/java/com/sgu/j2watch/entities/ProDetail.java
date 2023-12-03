package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProDetail {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_product")
	private int idProduct;
	
	@Column( name = "description")
    private String description;
	
	@Column( name = "code")
    private String code;
	
	@Column( name = "color")
    private String color;
	
	@Column( name = "shape")
    private String shape;
	
	@Column( name = "size")
    private String size;
	
	@Column( name = "water_resistance")
    private String water_resistance;
	
	@Column( name = "gender")
    private String gender;
	
	@Column( name = "origin")
    private String origin;
	
	public int getId_product() {
		return idProduct;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWater_resistance() {
		return water_resistance;
	}
	public void setWater_resistance(String water_resistance) {
		this.water_resistance = water_resistance;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setId_product(int id_product) {
		this.idProduct = id_product;
	}

	public ProDetail(int id_product, String description, String code, String color, String shape, String size,
			String water_resistance, String gender, String origin) {
		super();
		this.idProduct = id_product;
		this.description = description;
		this.code = code;
		this.color = color;
		this.shape = shape;
		this.size = size;
		this.water_resistance = water_resistance;
		this.gender = gender;
		this.origin = origin;
	}

	public ProDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProDetail [id_product=" + idProduct + ", description=" + description + ", code=" + code + ", color="
				+ color + ", shape=" + shape + ", size=" + size + ", water_resistance=" + water_resistance + ", gender="
				+ gender + ", origin=" + origin + "]";
	}
	
	
	
}
