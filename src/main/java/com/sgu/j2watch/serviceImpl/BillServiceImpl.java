package com.sgu.j2watch.serviceImpl;

import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.repositories.BillRepository;
import com.sgu.j2watch.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BillServiceImpl implements BillService {
    @Autowired
    private  BillRepository billRepository;

    @Override
    public Bill saveData(String deliver_address, Float totalPrice, int user_id, Integer voucher_id, int status_id, String dienthoai, String fullname, String email, String discription_bill) {
        Bill lastEntity = billRepository.findTopByOrderByIdDesc();

        int NextId = (lastEntity != null ) ? lastEntity.getId_bill() + (int) 1 : 1;

        Bill entity = new Bill();
        entity.setId_bill(NextId);
        entity.setDeliver_address(deliver_address);
        entity.setCreate_date(new Date());
        entity.setTotalPrice(totalPrice);
        entity.setUser_id(user_id);
        entity.setVoucher_id(voucher_id);
        entity.setStatus_id(status_id);
        entity.setDienthoai(dienthoai);
        entity.setFullname(fullname);
        entity.setEmail(email);
        entity.setDiscription_bill(discription_bill);
        return billRepository.save(entity);
    }
}
