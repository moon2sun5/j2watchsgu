package com.sgu.j2watch.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "material_glass")
public class MaterialGlass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_glass")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // Constructors, getters và setters
}