package com.sgu.j2watch.controllers;


import java.io.Console;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String AdminPage() {
        return "Admin/FormManager/MainPage";
    }

    
 
    
    // Quản lý tài khoản
    
// quản lí sản phẩm
//    @GetMapping("/qlsanpham")
//    public String qlsanpham() {
//        return "Admin/FormManager/M_Sanpham";
//    }

    @GetMapping("/qlhoadon")
    public String qlhoadon() {
        return "Admin/FormManager/M_Hoadon";
    }

    @GetMapping("/qlnhaphang")
    public String qlnhaphang() {
        return "Admin/FormManager/M_Nhaphang";
    }

    @GetMapping("/qlbaocao")
    public String qlbaocao() {
        return "Admin/FormManager/M_Baocao";
    }

    
// quản lí voucher
//    @GetMapping("/qlvoucher")
//    public String qlvoucher() {
//        return "Admin/FormManager/M_Voucher";
//    }

    

    // Quản lý thông tin
    

    
// quản lí sản phẩm
//    @GetMapping("/qlsanpham/addsanpham")
//    public String addsanpham() {
//        return "Admin/FormAdd/A_Sanpham";
//    }

    @GetMapping("/qlnhaphang/addnhaphang")
    public String addnhaphang() {
        return "Admin/FormAdd/A_Nhaphang";
    }

    // quản lí nhà cung cấp
//    @GetMapping("/qlnhacungcap/addnhacungcap")
//    public String addnhacungcap() {
//        return "Admin/FormAdd/A_Nhacungcap";
//    }
//    quản lí voucher
//    @GetMapping("/qlvoucher/addvoucher")
//    public String addvoucher() {
//        return "Admin/FormAdd/A_Voucher";
//    }

    // Quản lý quyền
    
}
