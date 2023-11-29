package com.sgu.j2watch.serviceImpl;

import com.sgu.j2watch.entities.ProductDetail;
import com.sgu.j2watch.repositories.ProductDetailRepository;
import com.sgu.j2watch.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDetailServicelmpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public Iterable<ProductDetail> findAll(){ return productDetailRepository.findAll();}

    @Override
    public Optional<ProductDetail> findById(int id) {
        return productDetailRepository.findById(id);
    }
}
