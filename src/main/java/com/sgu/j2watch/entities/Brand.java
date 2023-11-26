package com.sgu.j2watch.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_band") // Sửa từ id_brand sang id_band để khớp với cơ sở dữ liệu
    private Integer idBand;

    @Column(name = "name", length = 100)
    private String name;

    // Constructors
    public Brand() {
    }

    public Brand(Integer idBand, String name) {
        this.idBand = idBand;
        this.name = name;
    }

    // Getters và setters
    public Integer getIdBand() {
        return idBand;
    }

    public void setIdBand(Integer idBand) {
        this.idBand = idBand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}