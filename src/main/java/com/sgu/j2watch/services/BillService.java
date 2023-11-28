package com.sgu.j2watch.services;

import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface BillService {
    public Bill saveData(String deliver_address, Float totalPrice, int user_id, Integer voucher_id, int status_id, String dienthoai, String fullname, String email, String discription_bill);
}
