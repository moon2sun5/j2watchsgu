package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sgu.j2watch.entities.Receipt_detail;
import com.sgu.j2watch.entities.Supplier;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.repositories.ReceiptDetailRepository;
import com.sgu.j2watch.repositories.ReceiptRepository;
import com.sgu.j2watch.repositories.SupplierRepository;
import com.sgu.j2watch.repositories.UserRepository;

@Controller
@RequestMapping(path = "admin")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ReceiptDetailRepository receiptDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

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
    
    

    @GetMapping("/qlnhaphang")
    public String qlnhaphang( Model model) {
    	model.addAttribute("listReceipt", receiptRepository.findAll());
    	model.addAttribute("listReceiptDetail", receiptDetailRepository.findAll());
    	model.addAttribute("listSupplier", supplierRepository.findAll());
    	model.addAttribute("listUser", userRepository.findAll());
    	model.addAttribute("listProduct", productRepository.findAll());
        return "Admin/FormManager/M_Nhaphang";
    }
    @GetMapping("/qlnhaphang/addnhaphang")
    public String addnhaphang() {
        return "Admin/FormAdd/A_Nhaphang";
    }
    
    @GetMapping("/qlnhaphang/delete/{id_receipt}")
    public String deletedonhang(@PathVariable("id_receipt") Integer id_receipt) {
    	receiptRepository.deleteById(id_receipt);
    	Iterable<Receipt_detail> receiptIterable = receiptDetailRepository.findAll();
    	for(Receipt_detail receipt_detail : receiptIterable) {
    		if(receipt_detail.getReceipt_id() == id_receipt) {
    			 receiptDetailRepository.deleteById(receipt_detail.getReceipt_id());
    		}
    	}
        return "redirect:/admin/qlnhaphang";
    }
}
