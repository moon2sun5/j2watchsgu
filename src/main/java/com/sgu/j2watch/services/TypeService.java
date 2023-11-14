package com.sgu.j2watch.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Type;


@Service
public interface TypeService{
	public Iterable<Type> findAll();
	
	public Optional<Type> findById(int id_type);
}
