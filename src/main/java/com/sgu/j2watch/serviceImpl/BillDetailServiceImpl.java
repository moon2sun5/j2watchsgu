package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.DTOs.ThongkeTopSPDTO;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.BillDetailRepository;
import com.sgu.j2watch.services.BillDetailService;


@Service
public class BillDetailServiceImpl implements BillDetailService {

	@Autowired
	private BillDetailRepository  billDetailRepository;
	
	@Override
	public List<ThongkeTopSPDTO> getTop10BestSellingProducts() {
		return billDetailRepository.findTop10BestSellingProducts();
		}
	
}
