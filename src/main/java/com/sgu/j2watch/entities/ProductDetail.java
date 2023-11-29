package com.sgu.j2watch.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_detail")

public class ProductDetail {
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

    @Column(name = "brand_name")
    private String productBrand;

    @Column(name = "material_glass_name")
    private String productMaterialGlass;

    @Column(name = "material_wire_name")
    private String productMaterialWire;

    @Column(name = "pin_name")
    private String productPin;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "code")
    private String productCode;

    @Column(name = "color")
    private String productColor;

    @Column(name = "shape")
    private String productShape;

    @Column(name = "size")
    private String productSize;

    @Column(name = "water_resistance")
    private String productWater_Resistance;

    @Column(name = "gender")
    private String productGender;

    @Column(name = "origin")
    private String productOrigin;

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
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

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductMaterialGlass() {
        return productMaterialGlass;
    }

    public void setProductMaterialGlass(String productMaterialGlass) {
        this.productMaterialGlass = productMaterialGlass;
    }

    public String getProductMaterialWire() {
        return productMaterialWire;
    }

    public void setProductMaterialWire(String productMaterialWire) {
        this.productMaterialWire = productMaterialWire;
    }

    public String getProductPin() {
        return productPin;
    }

    public void setProductPin(String productPin) {
        this.productPin = productPin;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductShape() {
        return productShape;
    }

    public void setProductShape(String productShape) {
        this.productShape = productShape;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductWater_Resistance() {
        return productWater_Resistance;
    }

    public void setProductWater_Resistance(String productWater_Resistance) {
        this.productWater_Resistance = productWater_Resistance;
    }

    public String getProductGender() {
        return productGender;
    }

    public void setProductGender(String productGender) {
        this.productGender = productGender;
    }

    public ProductDetail() {
    }

    public ProductDetail(int productID, String productName, String productImg, float productPrice, int productQuantity, String productBrand, String productMaterialGlass, String productMaterialWire, String productPin, String productDescription, String productCode, String productColor, String productShape, String productSize, String productWater_Resistance, String productGender, String productOrigin) {
        this.productID = productID;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
        this.productMaterialGlass = productMaterialGlass;
        this.productMaterialWire = productMaterialWire;
        this.productPin = productPin;
        this.productDescription = productDescription;
        this.productCode = productCode;
        this.productColor = productColor;
        this.productShape = productShape;
        this.productSize = productSize;
        this.productWater_Resistance = productWater_Resistance;
        this.productGender = productGender;
        this.productOrigin = productOrigin;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productBrand='" + productBrand + '\'' +
                ", productMaterialGlass='" + productMaterialGlass + '\'' +
                ", productMaterialWire='" + productMaterialWire + '\'' +
                ", productPin='" + productPin + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productShape='" + productShape + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productWater_Resistance='" + productWater_Resistance + '\'' +
                ", productGender='" + productGender + '\'' +
                ", productOrigin='" + productOrigin + '\'' +
                '}';
    }
}