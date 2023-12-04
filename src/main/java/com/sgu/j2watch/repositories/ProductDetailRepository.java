package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    @Query(value = "SELECT a.name,a.img,a.price,a.quantity,brand.name as  brand_name ,material_glass.name as material_glass_name, material_wire.name as material_wire_name, pin.name as pin_name,product_detail.* \n" +
            "FROM (SELECT * FROM j2watch.product WHERE product.id_product = :id) a\n" +
            "INNER JOIN j2watch.brand ON a.brand_id = brand.id_band\n" +
            "INNER JOIN j2watch.material_glass ON a.material_glass_id = material_glass.id_material_glass \n" +
            "INNER JOIN j2watch.material_wire ON a.material_wire_id = material_wire.id_material_wire \n" +
            "INNER JOIN j2watch.pin ON a.pin_id = pin.id_pin\n" +
            "INNER JOIN j2watch.product_detail ON a.id_product = product_detail.id_product;\n", nativeQuery = true)
    public ProductDetail findProductDetailByID  (int id);
    @Query(value = "INSERT INTO your_table (column1, column2, column3,)\n" +
            "VALUES (:value1, 'value2', 'value3');", nativeQuery = true)
    public boolean save(int value1);
}
