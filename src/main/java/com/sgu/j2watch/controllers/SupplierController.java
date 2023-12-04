package com.sgu.j2watch.controllers;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.entities.Receipt;
import com.sgu.j2watch.entities.ReceiptSupplier;
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
    public String qlnhaphang(Model model) {
        model.addAttribute("listReceipt", receiptRepository.findAll());
        model.addAttribute("listReceiptDetail", receiptDetailRepository.findAll());
        model.addAttribute("listSupplier", supplierRepository.findAll());
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listProduct", productRepository.findAll());
        return "Admin/FormManager/M_Nhaphang";
    }

    @GetMapping("/qlnhaphang/addnhaphang")
    public String addnhaphang(Model model) {

        ReceiptSupplier receiptSupplier = new ReceiptSupplier();
        receiptSupplier.setReceipt(new Receipt());
        receiptSupplier.setReceipt_detail(new Receipt_detail());
        model.addAttribute("receiptSupplier", receiptSupplier);
        model.addAttribute("listSupplier", supplierRepository.findAll());
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listProduct", productRepository.findAll());
        return "Admin/FormAdd/A_Nhaphang";
    }

    @PostMapping("/qlnhaphang/addnhaphang")
    public String receiptSupplier(@ModelAttribute("receiptSupplier") ReceiptSupplier receiptSupplier) {
        receiptRepository.save(receiptSupplier.getReceipt());
        receiptSupplier.getReceipt_detail().setReceipt_id(receiptSupplier.getReceipt().getId_receipt());
        receiptDetailRepository.save(receiptSupplier.getReceipt_detail());
        float priceBuy = receiptSupplier.getReceipt_detail().getPrice() + (receiptSupplier.getReceipt_detail().getPercent() * receiptSupplier.getReceipt_detail().getPrice());
        Iterable<Product> productIterable = productRepository.findAll();
        for (Product product : productIterable) {
            if (receiptSupplier.getReceipt_detail().getProduct_id() == product.getIdProduct()) {
                product.setPrice(priceBuy);
                product.setQuantity(product.getQuantity() + receiptSupplier.getReceipt_detail().getQuantity());
                productRepository.save(product);
            }
        }
        return "redirect:/admin/qlnhaphang";
    }

    @GetMapping("/qlnhaphang/delete/{id_receipt}")
    public String deletedonhang(@PathVariable("id_receipt") Integer id_receipt) {
        Iterable<Receipt_detail> receiptIterable = receiptDetailRepository.findAll();
        for (Receipt_detail receipt_detail : receiptIterable) {
            if (receipt_detail.getReceipt_id() == id_receipt) {
                receiptDetailRepository.deleteById(receipt_detail.getId_receipt_detail());
            }
        }
        receiptRepository.deleteById(id_receipt);
        return "redirect:/admin/qlnhaphang";
    }

    @GetMapping("/qlnhaphang/edit/{id_receipt}")
    public String editNhaphang(@PathVariable("id_receipt") Integer id_receipt, Model model) {
        model.addAttribute("listSupplier", supplierRepository.findAll());
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listProduct", productRepository.findAll());
        ReceiptSupplier receiptSupplier = new ReceiptSupplier();

        Optional<Receipt> receiptOptional = receiptRepository.findById(id_receipt);
        Iterable<Receipt_detail> receiptIterable = receiptDetailRepository.findAll();
        for (Receipt_detail receipt_detail : receiptIterable) {
            if (receipt_detail.getReceipt_id() == id_receipt) {
//    			System.out.println(id_receipt);
//    			System.out.println(receipt_detail.getReceipt_id());
                Optional<Receipt_detail> receiptDetailOptional = receiptDetailRepository.findById(receipt_detail.getId_receipt_detail());
                receiptSupplier.setReceipt_detail(receiptDetailOptional.get());
                receiptSupplier.setReceipt(receiptOptional.get());
            }
        }
        model.addAttribute("receiptSupplier", receiptSupplier);
        return "Admin/FormManager/M_Nhaphang";
    }

    @PostMapping("/qlnhaphang/saveNhaphang/{id}")
    public String updateNhaphang(@PathVariable("id") Integer id_receipt, ReceiptSupplier receiptSupplier) {

        Iterable<Receipt_detail> receiptIterable = receiptDetailRepository.findAll();
        for (Receipt_detail receipt_detail : receiptIterable) {
            if (receipt_detail.getReceipt_id() == id_receipt) {
//    			System.out.println(id_receipt);
//    			System.out.println(receipt_detail.getReceipt_id());
                float priceBuy = receiptSupplier.getReceipt_detail().getPrice() + (receiptSupplier.getReceipt_detail().getPercent() * receiptSupplier.getReceipt_detail().getPrice());

                Optional<Receipt_detail> receiptDetailOptional = receiptDetailRepository.findById(receipt_detail.getId_receipt_detail());
                Receipt_detail receiptDetail = receiptDetailOptional.get();
                int oldProduct = receiptDetail.getProduct_id();
                int oldQuantity = receiptDetail.getQuantity();
                if (receiptSupplier.getReceipt_detail().getProduct_id() != oldProduct) {
                    Iterable<Product> productIterable = productRepository.findAll();
                    for (Product product : productIterable) {
                        if (product.getIdProduct() == oldProduct) {
                            product.setQuantity(product.getQuantity() - oldQuantity);
                            productRepository.save(product);
                        }
                    }
                    for (Product product : productIterable) {
                        if (product.getIdProduct() == receiptSupplier.getReceipt_detail().getProduct_id()) {
                            product.setPrice(priceBuy);
                            product.setQuantity(product.getQuantity() + receiptSupplier.getReceipt_detail().getQuantity());
                            productRepository.save(product);
                        }
                    }

                } else {
                    if (receiptSupplier.getReceipt_detail().getQuantity() >= oldQuantity) {
                        Iterable<Product> productIterable = productRepository.findAll();
                        for (Product product : productIterable) {
                            if (product.getIdProduct() == oldProduct) {
                                product.setPrice(priceBuy);
                                product.setQuantity(product.getQuantity() + (receiptSupplier.getReceipt_detail().getQuantity() - oldQuantity));
                                productRepository.save(product);
                            }
                        }
                    } else {
                        Iterable<Product> productIterable = productRepository.findAll();
                        for (Product product : productIterable) {
                            if (product.getIdProduct() == oldProduct) {
                                product.setPrice(priceBuy);
                                product.setQuantity(product.getQuantity() - (oldQuantity - receiptSupplier.getReceipt_detail().getQuantity()));
                                productRepository.save(product);
                            }
                        }
                    }

                }
            }
        }
        receiptRepository.save(receiptSupplier.getReceipt());
        receiptSupplier.getReceipt_detail().setReceipt_id(receiptSupplier.getReceipt().getId_receipt());
        receiptDetailRepository.save(receiptSupplier.getReceipt_detail());
        return "redirect:/admin/qlnhaphang";
    }
}
