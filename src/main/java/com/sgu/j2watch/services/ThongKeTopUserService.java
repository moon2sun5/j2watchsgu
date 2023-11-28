package com.sgu.j2watch.services;

import java.util.List;

import com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO;

public interface ThongKeTopUserService {
	 public List<ThongKeTopNhanVienDTO> getTop5BestSalesStaff();
	 public List<ThongKeTopNhanVienDTO> getTop5CustomerBuy();
}
