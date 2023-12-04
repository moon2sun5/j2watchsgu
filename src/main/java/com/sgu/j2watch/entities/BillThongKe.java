package com.sgu.j2watch.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BillThongKe {
    @Id
    @Column(name = "id_bill")
    private int id;

    @Column(name = "deliver_address")
    private String deliver_address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "voucher_id")
    private Integer voucher_id;

    @Column(name = "status_bill")
    private int status_id;

    @Column(name = "dienthoai")
    private String dienthoai;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "description_bill", nullable = true)
    private String discription_bill;
}
