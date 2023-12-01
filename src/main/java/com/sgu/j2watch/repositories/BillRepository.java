package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    public Bill findTopByOrderByIdDesc();
    public List<Bill> findByCreateDateBetween(Date startDate, Date endDate);
}
