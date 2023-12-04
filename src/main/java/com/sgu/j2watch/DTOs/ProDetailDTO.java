package com.sgu.j2watch.DTOs;


public class ProDetailDTO {

    private int id_product;
    private String description;
    private String code;
    private String color;
    private String shape;
    private String size;
    private String water_resistance;
    private String gender;
    private String origin;
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
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
    public ProDetailDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

}