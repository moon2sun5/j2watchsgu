package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    public Bill findTopByOrderByIdDesc();
}
