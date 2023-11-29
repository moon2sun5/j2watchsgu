package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.entities.MaterialGlass;

public interface MaterialGlassService {

	List<MaterialGlass> getAllMaterialGlasses();

	MaterialGlass getMaterialGlassById(Integer id_material_glass);

	void saveMaterialGlass(MaterialGlass materialGlass);

	void deleteMaterialGlass(Integer id_material_glass);

}
