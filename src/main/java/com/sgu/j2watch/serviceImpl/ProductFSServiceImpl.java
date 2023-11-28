package com.sgu.j2watch.serviceImpl;


import com.sgu.j2watch.entities.ProductFS;
import com.sgu.j2watch.repositories.ProductFSRepository;
import com.sgu.j2watch.services.ProductFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFSServiceImpl implements ProductFSService {
    @Autowired
    private ProductFSRepository productFSRepository;

    public List<ProductFS> findProductsAndBrands(){
        return productFSRepository.findProductsAndBrands();
    }
    public ProductFS findProductByID(int id){
        return productFSRepository.findProductByID(id);
    }
    public List<ProductFS> findProductsAndBrandsWithCategoryAndPages(int category_id, int from, int size){
        return productFSRepository.findProductsAndBrandsWithCategoryAndPages(category_id,from,size);
    }
    public int findTotalProducts(int category_id){
        return productFSRepository.findTotalProducts(category_id);
    }



}
