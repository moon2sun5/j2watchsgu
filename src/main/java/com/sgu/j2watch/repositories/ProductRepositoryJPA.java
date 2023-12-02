package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.Product;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Integer>{
	
	@Query("SELECT pro FROM Product pro WHERE pro.name LIKE %?1%")
	List<Product> searchNameProduct(String keyName);
	
	@Query("SELECT pro FROM Product pro WHERE " +
	        "(:idCategory IS NULL OR pro.category.idCategory = :idCategory) AND " +
	        "(:idBand IS NULL OR pro.brand.idBand = :idBand) AND " +
	        "(:price IS NULL OR pro.price < :price)")
	List<Product> findByCondition(
	        @Param("idCategory") Integer id_category,
	        @Param("idBand") Integer id_brand,
	        @Param("price") Float price);
	
	@Query("SELECT P " +
	        "FROM BillDetail bd " +
	        "JOIN Product P ON bd.id_product = P.id_product " +
	        "GROUP BY bd.id_product, P.name " +
	        "ORDER BY SUM(bd.quantity) DESC " +
	        "LIMIT 3")
	List<Product> productBestSeller();
}
