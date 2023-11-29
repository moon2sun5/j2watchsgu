package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sgu.j2watch.entities.Supplier;
import com.sgu.j2watch.repositories.SupplierRepository;

@Controller
@RequestMapping(path = "admin")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/qlnhacungcap")
    public String qlnhacungcap(Model model) {
        model.addAttribute("listSupplier", supplierRepository.findAll());
        return "Admin/FormManager/M_Nhacungcap";
    }

    @GetMapping("/qlnhacungcap/addnhacungcap")
    public String addnhacungcap(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "Admin/FormAdd/A_Nhacungcap";
    }

    @PostMapping("/qlnhacungcap/addnhacungcap")
    public String saveNhacungcap(Supplier supplier) {
        supplierRepository.save(supplier);
        return "redirect:/admin/qlnhacungcap";
    }

    @GetMapping("/qlnhacungcap/delete/{id_supplier}")
    public String deleteNhacungcap(@PathVariable("id_supplier") Integer id_supplier) {
        supplierRepository.deleteById(id_supplier);
        return "redirect:/admin/qlnhacungcap";
    }

    @GetMapping("/qlnhacungcap/edit/{id_supplier}")
    public String editNhacungcap(@PathVariable("id_supplier") Integer id_supplier, Model model) {
    	model.addAttribute("listSupplier", supplierRepository.findAll());
        Optional<Supplier> supplierOptional = supplierRepository.findById(id_supplier);
        Supplier supplier = supplierOptional.get();
        model.addAttribute("supplier", supplier);
        return "Admin/FormManager/M_Nhacungcap";
    }

    @PostMapping("/qlnhacungcap/saveNhacungcap/{id_supplier}")
    public String updateNhacungcap(@PathVariable("id_supplier") Integer id_supplier, Supplier supplier) {
    	supplierRepository.save(supplier);
        return "redirect:/admin/qlnhacungcap";
    }
}
