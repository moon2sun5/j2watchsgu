package com.sgu.j2watch.entities;

import java.io.Serializable;

public class CustomKey  implements Serializable {

    private int id_bill;

    private int id_product;

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
}
