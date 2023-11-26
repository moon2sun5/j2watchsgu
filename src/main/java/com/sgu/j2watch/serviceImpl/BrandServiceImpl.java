package com.sgu.j2watch.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Brand;
import com.sgu.j2watch.repositories.BrandRepository;
import com.sgu.j2watch.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Integer id_brand) {
        return brandRepository.findById(id_brand).orElse(null);
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Integer id_brand) {
        brandRepository.deleteById(id_brand);
    }
}
