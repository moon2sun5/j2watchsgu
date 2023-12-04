package com.sgu.j2watch.controllers;


import java.io.Console;
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
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
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

    // Quản lý tài khoản

//    @GetMapping("/qlsanpham")
//    public String qlsanpham() {
//        return "Admin/FormManager/M_Sanpham";
//    }

    @GetMapping("/qlhoadon")
    public String qlhoadon() {
        return "Admin/FormManager/M_Hoadon";
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
