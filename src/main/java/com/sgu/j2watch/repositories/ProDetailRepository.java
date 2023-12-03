package com.sgu.j2watch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.ProDetail;
import com.sgu.j2watch.entities.Product;
@Repository
public interface ProDetailRepository extends JpaRepository<ProDetail, Integer> {

	public ProDetail findByidProduct(Integer idProduct);

}
