package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductFS {

    @Id
    @Column(name = "id_product")
    private int productID;

    @Column(name = "name")
    private String productName;

    @Column(name = "img")
    private String productImg;

    @Column(name = "price")
    private float productPrice;

    @Column(name = "quantity")
    private int productQuantity;

    @Column(name = "category_id")
    private int product_categoryID;

    @Column(name = "brand_id")
    private int product_brandID;

    @Column(name = "brand_name")
    private String product_brandName;

    @Column(name = "pin_id")
    private Integer product_pinID;

    public ProductFS(int productID, String productName, String productImg, float productPrice, int productQuantity, int product_categoryID, int product_brandID, String product_brandName, Integer product_pinID, int product_materialWireID, int product_materialGlassID) {
        this.productID = productID;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.product_categoryID = product_categoryID;
        this.product_brandID = product_brandID;
        this.product_brandName = product_brandName;
        this.product_pinID = product_pinID;
        this.product_materialWireID = product_materialWireID;
        this.product_materialGlassID = product_materialGlassID;
    }

    @Column(name = "material_wire_id")
    private int product_materialWireID;

    public ProductFS() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProduct_categoryID() {
        return product_categoryID;
    }

    public void setProduct_categoryID(int product_categoryID) {
        this.product_categoryID = product_categoryID;
    }

    public int getProduct_brandID() {
        return product_brandID;
    }

    public void setProduct_brandID(int product_brandID) {
        this.product_brandID = product_brandID;
    }

    public String getProduct_brandName() {
        return product_brandName;
    }

    public void setProduct_brandName(String product_brandName) {
        this.product_brandName = product_brandName;
    }

    public Integer getProduct_pinID() {
        return product_pinID;
    }

    public void setProduct_pinID(Integer product_pinID) {
        this.product_pinID = product_pinID;
    }

    public int getProduct_materialWireID() {
        return product_materialWireID;
    }

    public void setProduct_materialWireID(int product_materialWireID) {
        this.product_materialWireID = product_materialWireID;
    }

    public int getProduct_materialGlassID() {
        return product_materialGlassID;
    }

    public void setProduct_materialGlassID(int product_materialGlassID) {
        this.product_materialGlassID = product_materialGlassID;
    }

    @Column(name = "material_glass_id")
    private int product_materialGlassID;

    @Override
    public String toString() {
        return "ProductFS{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", product_categoryID=" + product_categoryID +
                ", product_brandID=" + product_brandID +
                ", product_brandName='" + product_brandName + '\'' +
                ", product_pinID=" + product_pinID +
                ", product_materialWireID=" + product_materialWireID +
                ", product_materialGlassID=" + product_materialGlassID +
                '}';
    }
}
