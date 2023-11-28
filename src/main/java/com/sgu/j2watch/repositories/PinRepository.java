package com.sgu.j2watch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Integer> {
    // Có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}