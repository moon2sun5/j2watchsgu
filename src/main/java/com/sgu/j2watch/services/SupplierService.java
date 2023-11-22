package com.sgu.j2watch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Supplier;

@Service
public interface SupplierService {
	Supplier getSupplierById(int id);
    List<Supplier> getAllSuppliers();
    void saveSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
	Supplier getSupplierById(Long id);
	void deleteSupplier(Long id);
}
