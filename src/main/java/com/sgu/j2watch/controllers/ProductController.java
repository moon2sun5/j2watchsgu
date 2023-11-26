package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.repositories.ProductRepository;
import com.sgu.j2watch.services.BrandService;
import com.sgu.j2watch.services.CategoryService;

@Controller
@RequestMapping(path = "/admin/qlsanpham")
public class ProductController {

    private final ProductRepository productRepository;
    private final BrandService brandService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductRepository productRepository, BrandService brandService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String listProducts(Model model) {
        model.addAttribute("listProduct", productRepository.findAll());
        return "Admin/FormManager/M_Sanpham";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listBrand", brandService.getAllBrands());
        model.addAttribute("listCategory", categoryService.getAllCategories());
        return "Admin/FormAdd/A_Sanpham";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:/admin/qlsanpham";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
        return "redirect:/admin/qlsanpham";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Integer id, Model model) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("listBrand", brandService.getAllBrands());
            model.addAttribute("listCategory", categoryService.getAllCategories());
            return "Admin/FormAdd/A_Sanpham";
        } else {
            // Redirect to the list page if the product is not found
            return "redirect:/admin/qlsanpham";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        // Update the properties of the existing product with productDetails
        // Assumption: productDetails contains the updated values for the product
        // You may need to copy each property manually if the POSTed Product object
        // does not contain all the necessary attributes or contains null values.
//        existingProduct.setName(productDetails.getName());
//        existingProduct.setPrice(productDetails.getPrice());
        // ... copy other properties as needed

        productRepository.save(existingProduct);
        return "redirect:/admin/qlsanpham";
    }
}