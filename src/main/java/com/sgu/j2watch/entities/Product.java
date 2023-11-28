package com.sgu.j2watch.entities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "product")
//public class Product {
//	@Id
//	@Column(name = "id_product")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	
//    private int id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "price")
//    private float price;
//
//    @OneToMany(mappedBy = "product")
//    private List<BillDetail> billDetails;
//
//    // Other fields like img, quantity, category_id, etc.
//
//    // Getters and setters
//}


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;
    private String name;
    private String img;
    private float price;
    private int quantity;
    private int category_id;
    private int brand_id;
    private int pin_id;
    private int material_wire_id;
    private int material_glass_id;
    
    
   
	
    // Getter and Setter methods
}