package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Supplier;
import com.sgu.j2watch.repositories.SupplierRepository;
import com.sgu.j2watch.services.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
