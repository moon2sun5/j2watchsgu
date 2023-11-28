package com.sgu.j2watch.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO;
import com.sgu.j2watch.entities.Bill;

public interface ThongKeTopUserRepository extends JpaRepository <Bill, Integer>{
	@Query("SELECT new com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO(B.user_id, U.type, U.name, SUM(B.total_price)) " +
		       "FROM Bill B, Type T, User U " +
		       "WHERE T.id_type = 1 AND B.user_id = U.id_user AND T.id_type = U.type " +
		       "GROUP BY B.user_id, U.type, U.name " +
		       "ORDER BY SUM(B.total_price) DESC " +
		       "LIMIT 5")
		List<ThongKeTopNhanVienDTO> findTop5BestSaleaStaff();


	@Query("SELECT new com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO(B.user_id, U.type, U.name, SUM(B.total_price)) " +
		       "FROM Bill B, Type T, User U " +
		       "WHERE T.id_type = 2 AND B.user_id = U.id_user AND T.id_type = U.type " +
		       "GROUP BY B.user_id, U.type, U.name " +
		       "ORDER BY SUM(B.total_price) DESC " +
		       "LIMIT 5")
		List<ThongKeTopNhanVienDTO> findTop5CustomerBuy();
}
