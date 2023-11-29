package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.ProductFS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFSRepository extends JpaRepository<ProductFS, Integer> {
    @Query(value = "SELECT product.*,brand.name as brand_name  FROM j2watch.product INNER JOIN j2watch.brand ON product.brand_id = brand.id_band ;", nativeQuery = true)
    List<ProductFS> findProductsAndBrands();

    @Query(value = "SELECT * FROM (SELECT product.*,brand.name as brand_name FROM j2watch.product INNER JOIN j2watch.brand ON product.brand_id = brand.id_band) a WHERE a.id_product = :id", nativeQuery = true)
    ProductFS findProductByID(int id);

    @Query(value = "SELECT * FROM (SELECT product.*,brand.name as brand_name FROM j2watch.product INNER JOIN j2watch.brand ON product.brand_id = brand.id_band) a WHERE a.category_id = :category_id ORDER BY a.id_product LIMIT :from, :size ;", nativeQuery = true)
    List<ProductFS> findProductsAndBrandsWithCategoryAndPages(int category_id, int from, int size);

    @Query(value = "SELECT Count(a.id_product) FROM (SELECT product.*,brand.name as brand_name FROM j2watch.product INNER JOIN j2watch.brand ON product.brand_id = brand.id_band) a WHERE a.category_id = :category_id ", nativeQuery = true)
    int findTotalProducts(int category_id);
}