package com.sgu.j2watch.services;

import com.sgu.j2watch.DTOs.CartProductDTO;
import com.sgu.j2watch.entities.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillDetailService {
    public void saveData(Bill bill, List<CartProductDTO> cartProductDTOList);
}
