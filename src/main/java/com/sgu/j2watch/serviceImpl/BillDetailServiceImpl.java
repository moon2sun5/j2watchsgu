package com.sgu.j2watch.serviceImpl;

import com.sgu.j2watch.DTOs.CartProductDTO;
import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.repositories.BillDetailRepository;
import com.sgu.j2watch.repositories.ProductFSRepository;
import com.sgu.j2watch.services.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDetailServiceImpl implements BillDetailService {

    private final BillDetailRepository billDetailRepository;

    @Autowired
    public ProductFSRepository productFSRepository;

    @Autowired
    public BillDetailServiceImpl(BillDetailRepository repository) {
        this.billDetailRepository = repository;
    }

    @Override
    public void saveData(Bill bill, List<CartProductDTO> cartProductDTOList) {
        for (CartProductDTO cartProductDto : cartProductDTOList) {
            BillDetail billDetail = new BillDetail();
            billDetail.setId_bill(bill.getId());
            billDetail.setId_product(cartProductDto.getId());
            billDetail.setUnit_price(cartProductDto.getPrice());
            billDetail.setQuantity(cartProductDto.getQuantity());
            billDetailRepository.save(billDetail);
        }
    }
}
