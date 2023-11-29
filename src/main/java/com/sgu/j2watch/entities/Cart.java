package com.sgu.j2watch.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    private int productID;

    @Override
    public String toString() {
        return "Cart{" +
                "productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart(int productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public Cart() {
    }

    private int quantity;

}
