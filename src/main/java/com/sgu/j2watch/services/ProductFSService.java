package com.sgu.j2watch.services;

import com.sgu.j2watch.entities.ProductFS;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductFSService {
    public List<ProductFS> findProductsAndBrands();
    public ProductFS findProductByID(int id);
    public List<ProductFS> findProductsAndBrandsWithCategoryAndPages(int category_id, int from, int size);
    public int findTotalProducts(int category_id);

}
