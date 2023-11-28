package com.sgu.j2watch.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id_bill;

	    private float total_price;

	    private int user_id;

}
