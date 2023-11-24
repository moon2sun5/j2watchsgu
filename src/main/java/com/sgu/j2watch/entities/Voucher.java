package com.sgu.j2watch.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voucher")
    private Integer id_voucher;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private Float value;

    @Column(name = "start_date")
    private Date start_Date;

    @Column(name = "end_date")
    private Date end_Date;

    public Voucher(Integer id_voucher, String code, Float value, Date start_Date, Date end_Date) {
        this.id_voucher = id_voucher;
        this.code = code;
        this.value = value;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public Integer getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(Integer id_voucher) {
        this.id_voucher = id_voucher;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public Voucher() {
        super();
    }
}
