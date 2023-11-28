package com.sgu.j2watch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgu.j2watch.entities.MaterialGlass;

@Repository
public interface MaterialGlassRepository extends JpaRepository<MaterialGlass, Integer> {
}
