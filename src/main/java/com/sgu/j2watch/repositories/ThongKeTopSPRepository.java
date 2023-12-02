package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.DTOs.ThongkeTopSPDTO;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Product;

@Repository
public interface  ThongKeTopSPRepository  extends JpaRepository<BillDetail, Integer> {
	@Query(value = "SELECT new com.sgu.j2watch.DTOs.ThongkeTopSPDTO(bd.id_product, P.name, SUM(bd.quantity)) " +
		       "FROM BillDetail bd, Product P " +
		       "WHERE bd.id_product = P.id_product " +
		       "GROUP BY bd.id_product, P.name " +
		       "ORDER BY SUM(bd.quantity) DESC " +
		       "LIMIT 10", nativeQuery = false)
		List<ThongkeTopSPDTO> findTop10BestSellingProducts();


}
