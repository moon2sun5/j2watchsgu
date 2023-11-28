package com.sgu.j2watch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.MaterialWire;

@Repository
public interface MaterialWireRepository extends JpaRepository<MaterialWire, Integer> {
}
