package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO;
import com.sgu.j2watch.repositories.ThongKeTopUserRepository;
import com.sgu.j2watch.services.ThongKeTopUserService;

@Service
public class ThongKeTopUserServiceImpl implements ThongKeTopUserService{
	@Autowired
	private ThongKeTopUserRepository  thongKeTopUserRepository;
	
	@Override
	public List<ThongKeTopNhanVienDTO> getTop5BestSalesStaff() {
		return thongKeTopUserRepository.findTop5BestSaleaStaff();
		
		}

	@Override
	public List<ThongKeTopNhanVienDTO> getTop5CustomerBuy() {
		return thongKeTopUserRepository.findTop5CustomerBuy();
		
		}
}
