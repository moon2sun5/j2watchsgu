package com.sgu.j2watch.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sgu.j2watch.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByBrand_IdBand(Integer idBand);

    List<Product> findByCategory_IdCategory(Integer id_category);

}
