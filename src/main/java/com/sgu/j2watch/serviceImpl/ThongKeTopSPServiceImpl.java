package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.DTOs.ThongkeTopSPDTO;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.ThongKeTopSPRepository;
import com.sgu.j2watch.services.ThongKeTopSPService;


@Service
public class ThongKeTopSPServiceImpl implements ThongKeTopSPService {

	@Autowired
	private ThongKeTopSPRepository  thongKeTopSPRepository;
	
	@Override
	public List<ThongkeTopSPDTO> getTop10BestSellingProducts() {
		return thongKeTopSPRepository.findTop10BestSellingProducts();
		}
	
}
