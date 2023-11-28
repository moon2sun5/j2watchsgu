package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.entities.Brand;

public interface BrandService {

	List<Brand> getAllBrands();

	Brand getBrandById(Integer id_brand);

	void saveBrand(Brand brand);

	void deleteBrand(Integer id_brand);

}
