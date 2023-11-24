package com.sgu.j2watch.controllers;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.sgu.j2watch.DTOs.ThongKeTopNhanVienDTO;
import com.sgu.j2watch.DTOs.ThongkeTopSPDTO;
import com.sgu.j2watch.services.ThongKeTopSPService;
import com.sgu.j2watch.services.ThongKeTopUserService;


@Controller
//@RequestMapping(path = "/admin/qlthongkesp")

@RequestMapping(path = "/admin")
public class ThongKeController {
	@Autowired
    private ThongKeTopSPService thongKeTopSPService ;
	
	@Autowired
	private ThongKeTopUserService thongKeTopUserService;

	@PostMapping("/qlthongkesp/qlthongkesptungmuc")
	public ModelAndView thongKeSanPham(@RequestParam("thongkeOption") Integer thongkeOption) {
	    if (thongkeOption == 1) {
	    	List<ThongKeTopNhanVienDTO> topCustomers   = thongKeTopUserService.getTop5CustomerBuy();
	    	 ModelAndView modelAndView = new ModelAndView("Admin/FormManager/ThongKeThai/Top5KHMuaNhieuNhat");
		        modelAndView.addObject("topCustomers", topCustomers);
		        return modelAndView;
	    } else if((thongkeOption == 2)){
	    	 List<ThongkeTopSPDTO> topProducts = thongKeTopSPService.getTop10BestSellingProducts();
		        ModelAndView modelAndView = new ModelAndView("Admin/FormManager/ThongKeThai/Top10SpBanChay");
		        modelAndView.addObject("topProducts", topProducts);
		        return modelAndView;
	    }else {
	    	List<ThongKeTopNhanVienDTO> topStaff  = thongKeTopUserService.getTop5BestSalesStaff();
	    	 ModelAndView modelAndView = new ModelAndView("Admin/FormManager/ThongKeThai/Top5NhanVienBanNhieuNhat");
		        modelAndView.addObject("topStaff", topStaff);
		        return modelAndView;
	    }
	}






}
