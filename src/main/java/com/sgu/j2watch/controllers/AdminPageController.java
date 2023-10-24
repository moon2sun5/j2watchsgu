package com.sgu.j2watch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminPageController {
    @GetMapping("")
    public String AdminPage() {
        return "Admin/FormManager/MainPage";
    }

    @GetMapping("/qlthongtin")
    public String qlthongtin() {
        return "Admin/FormManager/M_Thongtin";
    }

    @GetMapping("/qltaikhoan")
    public String qltaikhoan() {
        return "Admin/FormManager/M_Taikhoan";
    }

    @GetMapping("/qlsanpham")
    public String qlsanpham() {
        return "Admin/FormManager/M_Sanpham";
    }

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

    @GetMapping("/qlnhacungcap")
    public String qlnhacungcap() {
        return "Admin/FormManager/M_Nhacungcap";
    }

    @GetMapping("/qlvoucher")
    public String qlvoucher() {
        return "Admin/FormManager/M_Voucher";
    }

    @GetMapping("/qlquyen")
    public String qlquyen() {
        return "Admin/FormManager/M_Quyen";
    }

    @GetMapping("/qlthongtin/addthongtin")
    public String addthongtin() {
        return "Admin/FormAdd/A_Thongtin";
    }

    @GetMapping("/qltaikhoan/addtaikhoan")
    public String addtaikhoan() {
        return "Admin/FormAdd/A_Taikhoan";
    }

    @GetMapping("/qlsanpham/addsanpham")
    public String addsanpham() {
        return "Admin/FormAdd/A_Sanpham";
    }

    @GetMapping("/qlnhaphang/addnhaphang")
    public String addnhaphang() {
        return "Admin/FormAdd/A_Nhaphang";
    }

    @GetMapping("/qlnhacungcap/addnhacungcap")
    public String addnhacungcap() {
        return "Admin/FormAdd/A_Nhacungcap";
    }

    @GetMapping("/qlvoucher/addvoucher")
    public String addvoucher() {
        return "Admin/FormAdd/A_Voucher";
    }

    @GetMapping("/qlquyen/addquyen")
    public String addquyen() {
        return "Admin/FormAdd/A_Quyen";
    }
}
