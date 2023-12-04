package com.sgu.j2watch.controllers;


import java.io.Console;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.entities.BillDetail;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.BillDetailRepository;
import com.sgu.j2watch.repositories.BillRepository;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.repositories.VoucherRepository;
import com.sgu.j2watch.serviceImpl.AccountServiceImpl;
import com.sgu.j2watch.serviceImpl.RoleServiceImpl;
import com.sgu.j2watch.serviceImpl.UserServiceImpl;
import com.sgu.j2watch.services.RoleService;
import com.sgu.j2watch.services.UserService;

@Controller
@RequestMapping(path = "admin")
public class AdminPageController {
    @Autowired
    private BillService billService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String AdminPage() {
        return "Admin/FormManager/MainPage";
    }

    @Autowired
    private BillDetailRepository billDetailRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/qlhoadon")
    public String qlhoadon(Model model) {
    	model.addAttribute("listVoucher",voucherRepository.findAll());
    	model.addAttribute("listBill", billRepository.findAll());
        return "Admin/FormManager/M_Hoadon";
    }
    
    @GetMapping("/qlhoadon/delete/{id}")
    public String xoahoadon(@PathVariable("id") Integer id) {
    	Iterable<BillDetail> billDetailIterable = billDetailRepository.findAll();
    	for(BillDetail billDetail : billDetailIterable) {
    		if(billDetail.getId_bill() == id) {
    			billDetailRepository.deleteById(billDetail.getId_bill());    			
    		}
    	}
        billRepository.deleteById(id);
        return "redirect:/admin/qlhoadon";
    }
    
    @GetMapping("/qlhoadon/edit/{id}")
    public String edithoadon(@PathVariable("id") Integer id, Model model) {
    	model.addAttribute("product", productRepository.findAll());
    	Optional<Bill> billOptional = billRepository.findById(id);
    	Bill bill = billOptional.get();

//    	List<BillDetail> billdetail_list = new ArrayList();
    	Iterable<BillDetail> billDetailIterable = billDetailRepository.findAll();
    	for(BillDetail billDetail : billDetailIterable) {
    		if(billDetail.getId_bill() == id) {
    			List<BillDetail> billdetail_list = billDetailRepository.findAllById_bill(billDetail.getId_bill());
//    			billdetailList.addAll(billdetail_list);
    			model.addAttribute("listBilldetail", billdetail_list);
    		}
    	}
    	
    	model.addAttribute("listBillEdit", bill);
        return "Admin/FormEdit/E_Hoadon";
    }
    
    @PostMapping("/qlhoadon/saveHoadon")
    public String savehoadon(@ModelAttribute("bill") Bill bill) {
    	Optional<Bill> billOptional = billRepository.findById(bill.getId_bill());
    	Bill billOld = billOptional.get();
    	
    	bill.setCreate_date(billOld.getCreate_date());
    	billRepository.save(bill);
    	
        return "redirect:/admin/qlhoadon";
    }

    @GetMapping("/qlbaocao")
    public String qlbaocao(Model model) {
        // Lấy dữ liệu doanh thu theo tháng và thứ
        List<Double> monthlyRevenueData = billService.getMonthlyRevenueData();
        List<Double> weeklyRevenueData = billService.getWeeklyRevenueData();

        // Truyền dữ liệu vào Thymeleaf Template
        model.addAttribute("monthlyData", monthlyRevenueData);
        model.addAttribute("weeklyData", weeklyRevenueData);

        return "Admin/FormManager/M_Baocao";
    }

    @GetMapping("/qlbaocao/billsByMonth")
    public String getBillsByMonth(
            @RequestParam(name = "year") int year,
            @RequestParam(name = "month") int month,
            Model model
    ) {
        List<Bill> bills;
        bills = billService.getBillsByMonth(year, month);
        model.addAttribute("bills", bills);
        return "Admin/FormManager/M_Baocao";
    }

//    @GetMapping("/qlnhacungcap")
//    public String qlnhacungcap() {
//        return "Admin/FormManager/M_Nhacungcap";
//    }

//    @GetMapping("/qlvoucher")
//    public String qlvoucher() {
//        return "Admin/FormManager/M_Voucher";
//    }

    // Quản lý thông tin

//    @GetMapping("/qlsanpham/addsanpham")
//    public String addsanpham() {
//        return "Admin/FormAdd/A_Sanpham";
//    }


//    @GetMapping("/qlnhacungcap/addnhacungcap")
//    public String addnhacungcap() {
//        return "Admin/FormAdd/A_Nhacungcap";
//    }

//    @GetMapping("/qlvoucher/addvoucher")
//    public String addvoucher() {
//        return "Admin/FormAdd/A_Voucher";
//    }
    
    @GetMapping("/qlthongkesp")
    public String qlthongkesp() {
        return "Admin/FormManager/ThonkeThai";
    } 

    // Quản lý quyền
}
