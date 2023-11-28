package com.sgu.j2watch.entities;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "img")
//    @Transient
    private String img;
    
    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id_band")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "pin_id", referencedColumnName = "id_pin") 
    private Pin pin;

    @ManyToOne
    @JoinColumn(name = "material_wire_id", referencedColumnName = "id_material_wire") 
    private MaterialWire materialWire;
    
    @ManyToOne
    @JoinColumn(name = "material_glass_id", referencedColumnName = "id_material_glass") 
    private MaterialGlass materialGlassId;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public MaterialWire getMaterialWire() {
		return materialWire;
	}

	public void setMaterialWire(MaterialWire materialWire) {
		this.materialWire = materialWire;
	}

	public MaterialGlass getMaterialGlassId() {
		return materialGlassId;
	}

	public void setMaterialGlassId(MaterialGlass materialGlassId) {
		this.materialGlassId = materialGlassId;
	}
}