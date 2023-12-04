package com.sgu.j2watch.repositories;

import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.entities.BillThongKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillThongKeRepository extends JpaRepository<BillThongKe, Integer> {
    public List<Bill> findByCreateDateBetween(Date startDate, Date endDate);
}
