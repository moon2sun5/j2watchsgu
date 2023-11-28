package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.MaterialWire;
import com.sgu.j2watch.repositories.MaterialWireRepository;
import com.sgu.j2watch.services.MaterialWireService;

@Service
public class MaterialWireServiceImpl implements MaterialWireService {
    @Autowired
    private MaterialWireRepository materialWireRepository;

    @Override
    public List<MaterialWire> getAllMaterialWires() {
        return materialWireRepository.findAll();
    }

    @Override
    public MaterialWire getMaterialWireById(Integer id_material_wire) {
        return materialWireRepository.findById(id_material_wire).orElse(null);
    }

    @Override
    public void saveMaterialWire(MaterialWire materialWire) {
        materialWireRepository.save(materialWire);
    }

    @Override
    public void deleteMaterialWire(Integer id_material_wire) {
        materialWireRepository.deleteById(id_material_wire);
    }
}
