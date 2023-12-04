package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.BillDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
	@Query("SELECT bd FROM BillDetail bd WHERE bd.id_bill = :id_bill")
    List<BillDetail> findAllById_bill(@Param("id_bill") Integer id_bill);
}
