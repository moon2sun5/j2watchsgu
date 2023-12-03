package com.sgu.j2watch.DTOs;

import org.springframework.web.multipart.MultipartFile;

import com.sgu.j2watch.entities.Brand;
import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.entities.MaterialGlass;
import com.sgu.j2watch.entities.MaterialWire;
import com.sgu.j2watch.entities.Newproduct;
import com.sgu.j2watch.entities.Pin;
import com.sgu.j2watch.entities.ProDetail;
import com.sgu.j2watch.entities.Product;


public class ProductDTO {
//	private String color;
	private Product product;
	public ProDetail prodetail;
    private Integer idProduct;
    private String name;
    private MultipartFile img;
    private Float price;
    private Integer quantity;
    private Category category;
    private Brand brand;
    private Pin pin;
    private MaterialWire materialWire;
    private MaterialGlass materialGlassId;

//    public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProDetail getProdetail() {
		return prodetail;
	}

	public void setProdetail(ProDetail prodetail) {
		this.prodetail = prodetail;
	}

	public static void setProduct(Newproduct newproduct) {
		// TODO Auto-generated method stub
		
	}
	
    public Integer getidProduct() {
        return idProduct;
    }

    public void setId_product(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
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

    public ProductDTO() {
        super();
    }

	public ProductDTO(Product product, ProDetail prodetail, Integer idProduct, String name, MultipartFile img,
			Float price, Integer quantity, Category category, Brand brand, Pin pin, MaterialWire materialWire,
			MaterialGlass materialGlassId) {
		super();
		this.product = product;
		this.prodetail = prodetail;
		this.idProduct = idProduct;
		this.name = name;
		this.img = img;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.brand = brand;
		this.pin = pin;
		this.materialWire = materialWire;
		this.materialGlassId = materialGlassId;
	}

    
    

   
}