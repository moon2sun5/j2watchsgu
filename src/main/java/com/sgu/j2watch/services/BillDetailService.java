package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.DTOs.ThongkeTopSPDTO;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Product;

public interface BillDetailService {
	 public List<ThongkeTopSPDTO> getTop10BestSellingProducts();
}
