package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.MaterialGlass;
import com.sgu.j2watch.repositories.MaterialGlassRepository;
import com.sgu.j2watch.services.MaterialGlassService;

@Service
public class MaterialGlassServiceImpl implements MaterialGlassService {
    @Autowired
    private MaterialGlassRepository materialGlassRepository;

    @Override
    public List<MaterialGlass> getAllMaterialGlasses() {
        return materialGlassRepository.findAll();
    }

    @Override
    public MaterialGlass getMaterialGlassById(Integer id_material_glass) {
        return materialGlassRepository.findById(id_material_glass).orElse(null);
    }

    @Override
    public void saveMaterialGlass(MaterialGlass materialGlass) {
        materialGlassRepository.save(materialGlass);
    }

    @Override
    public void deleteMaterialGlass(Integer id_material_glass) {
        materialGlassRepository.deleteById(id_material_glass);
    }
}
