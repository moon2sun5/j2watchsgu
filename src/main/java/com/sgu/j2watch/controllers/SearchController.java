package com.sgu.j2watch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sgu.j2watch.entities.Product;
import com.sgu.j2watch.entities.ProductFS;
import com.sgu.j2watch.repositories.BrandRepository;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.services.ProductFSService;
import com.sgu.j2watch.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "home")
public class SearchController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ProductService productService;
	@Autowired
    private ProductFSService productFSService;
	
//	@GetMapping("/timkiem")
//    public String qltimkiem(Model model) {  
//		model.addAttribute("listCategory", categoryRepository.findAll());
//		model.addAttribute("listBrand", brandRepository.findAll());
//        return "Home/MainPage/SearchPage";
//    }
	
	@GetMapping("/timkiem")
    public String timkiemKey(Model model, @Param("keyword") String keyword, @RequestParam(name = "category", required = false) List<Integer> category, @RequestParam(name = "brand", required = false) List<Integer> brand,  HttpServletRequest request) {  
		model.addAttribute("listCategory", categoryRepository.findAll());
		model.addAttribute("listBrand", brandRepository.findAll());
		List<Product> list = this.productService.getAllProducts();
//		System.out.println(request.getParameter("price_product"));
		Float price = 0f;
		String priceString = request.getParameter("price_product");
		
		if(priceString != null) {
			price = Float.parseFloat(priceString);
			if (price == 100000f) {
				price = 200000000f;
			}
			System.out.println("khác null" + price);
		}
		else {
			System.out.println("null" + price);
		}
		System.out.println(price);
		if(keyword != null) {
			list = this.productService.searchNameProduct(keyword);	
//			System.out.println("helloooo");
		}
		else{
			if (category != null && !category.isEmpty() && brand != null && !brand.isEmpty() && price > 100000.0) {
				System.out.println("Trường hợp lọc cả 3");
	            for (int v_category : category) {
	            	for (int v_brand : brand) {
	            		list = this.productService.findByCondition(v_category, v_brand, price);
	            	}
	            }
	        }
			
			else if (brand != null && !brand.isEmpty() && price > 100000.0){
				System.out.println("Trường hợp lọc brand vs giá");
				if(brand != null && !brand.isEmpty()) {
					for (int value : brand) {
						list = this.productService.findByCondition(null, value, price);
					}					
				}
			}
			else if (category != null && !category.isEmpty() && price > 100000.0){
				System.out.println("Trường hợp lọc category vs giá");
				if(category != null && !category.isEmpty()) {
					for (int value : category) {
						list = this.productService.findByCondition(value, null, price);
					}					
				}
			}
			else if (category != null && !category.isEmpty() && brand != null && !brand.isEmpty()){
				System.out.println("Trường hợp lọc giá vs category");
	            for (int v_category : category) {
	            	for (int v_brand : brand) {
	            		list = this.productService.findByCondition(v_category, v_brand, null);
	            	}
	            }
			}
			else if (category != null && !category.isEmpty() || brand != null && !brand.isEmpty() || price > 100000.0){
				System.out.println("Trường hợp lọc 1 trong 3");
				if(category != null && !category.isEmpty()) {
					for (int value : category) {
						list = this.productService.findByCondition(value, null, null);
					}					
				}
				else if(brand != null && !brand.isEmpty()) {
					for (int value : brand) {
						list = this.productService.findByCondition(null, value, null);
					}					
				}
				else if(price > 100000) {
					
					list = this.productService.findByCondition(null, null, price);					
				}
			}
		}
		model.addAttribute("listSearch", list);
        return "Home/MainPage/SearchPage";
    }
}
