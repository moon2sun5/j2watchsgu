package com.sgu.j2watch.entities;
import jakarta.persistence.*;

@Entity
@IdClass(CustomKey.class)
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @Column(name = "id_bill")
    private int id_bill;

    @Id
    @Column(name = "id_product")
    private int id_product;

    @Column(name = "unit_price")
    private float unit_price;

    @Column(name = "quantity")
    private int quantity;

    public BillDetail() {
    }

    public BillDetail(int id_bill, int id_product, float unit_price, int quantity) {
        this.id_bill = id_bill;
        this.id_product = id_product;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
