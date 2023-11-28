package com.sgu.j2watch.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgu.j2watch.entities.Type;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.services.TypeService;

@Component
public class TypeServiceImpl implements TypeService{
	@Autowired 
	private TypeRepository typeRepository;
	
	public Iterable<Type> findAll(){
		return typeRepository.findAll();
	}
	
	@Override
	public Optional<Type> findById(int id_type){
		return typeRepository.findById(id_type);
	}
}
