package com.sgu.j2watch.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sgu.j2watch.entities.Voucher;
import com.sgu.j2watch.repositories.VoucherRepository;

@Controller
@RequestMapping(path = "admin")
public class VoucherController {
    
    @Autowired
    private VoucherRepository voucherRepository;
    
    @GetMapping("/qlvoucher")
    public String qlvoucher(Model model) {
        model.addAttribute("listVoucher", voucherRepository.findAll());
        return "Admin/FormManager/M_Voucher";
    }

    @GetMapping("/qlvoucher/addvoucher")
    public String addvoucher(Model model) {
        Voucher voucher = new Voucher();
        model.addAttribute("voucher", voucher);
        return "Admin/FormAdd/A_Voucher";
    }

    @PostMapping("/qlvoucher/addvoucher")
    public String saveVoucher(@ModelAttribute("voucher") Voucher voucher,
                              @RequestParam("start_Date") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date start_Date,
                              @RequestParam("end_Date") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date end_Date) {
        voucher.setStart_Date(new java.sql.Date(start_Date.getTime()));
        voucher.setEnd_Date(new java.sql.Date(end_Date.getTime()));
        voucherRepository.save(voucher);
        return "redirect:/admin/qlvoucher";
    }

    @GetMapping("/qlvoucher/delete/{id_voucher}")
    public String deleteVoucher(@PathVariable("id_voucher") Integer id_voucher) {
        voucherRepository.deleteById(id_voucher);
        return "redirect:/admin/qlvoucher";
    }

    @GetMapping("/qlvoucher/edit/{id_voucher}")
    public String editVoucher(@PathVariable("id_voucher") Integer id_voucher, Model model) {
        model.addAttribute("listVoucher", voucherRepository.findAll());
        Optional<Voucher> voucherOptional = voucherRepository.findById(id_voucher);
        Voucher voucher = voucherOptional.orElse(new Voucher());
        model.addAttribute("voucher", voucher);
        return "Admin/FormManager/M_Voucher";
    }

    @PostMapping("/qlvoucher/saveVoucher/{id_voucher}")
    public String updateVoucher(@PathVariable("id_voucher") Integer id_voucher, Voucher voucher) {
        voucherRepository.save(voucher);
        return "redirect:/admin/qlvoucher";
    }
}
