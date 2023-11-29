package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.entities.MaterialWire;

public interface MaterialWireService {

	List<MaterialWire> getAllMaterialWires();

	MaterialWire getMaterialWireById(Integer id_material_wire);

	void saveMaterialWire(MaterialWire materialWire);

	void deleteMaterialWire(Integer id_material_wire);

	

}
