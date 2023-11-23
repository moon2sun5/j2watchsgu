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
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.services.BillDetailService;
import com.sgu.j2watch.services.UserService;


@Controller
//@RequestMapping(path = "/admin/qlthongkesp")

@RequestMapping(path = "/admin")
public class ThongKeController {
	@Autowired
    private BillDetailService billDetailService ;
	
	@Autowired
	private UserService userService;


//	    @GetMapping("/top6bestsellers")
////	    @ResponseBody
//	    public String abc() {
//	        return "Admin/FormManager/thongkesp/top10";
//    } 
	    
//	  @GetMapping("/top6bestsellers")
//	    public String displayTopProducts(Model model) {
//	        List<ThongkeTopSPDTO> topProducts = billDetailService.getTop7BestSellingProducts();
//	        model.addAttribute("topProducts", topProducts);
//	        return "Admin/FormManager/thongkesp/top10"; // Trả về tên trang HTML để hiển thị dữ liệu
//	    }
//	  



	@PostMapping("/qlthongkesptungcai")
	public ModelAndView thongKeSanPham(@RequestParam("thongkeOption") Integer thongkeOption) {
	     if((thongkeOption == 2)){
	    	 List<ThongkeTopSPDTO> topProducts = billDetailService.getTop10BestSellingProducts();
		        ModelAndView modelAndView = new ModelAndView("Admin/FormManager/top6");
		        modelAndView.addObject("topProducts", topProducts);
		        return modelAndView;
	    }else {
	    	return null;
	    }
	}






}
