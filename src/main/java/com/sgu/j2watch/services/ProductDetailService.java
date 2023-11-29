package com.sgu.j2watch.services;

import com.sgu.j2watch.entities.ProductDetail;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductDetailService {
    public Iterable<ProductDetail> findAll();

    public Optional<ProductDetail> findById(int id);
}
