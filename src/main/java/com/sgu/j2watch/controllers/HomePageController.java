package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.repositories.UserRepository;

// Cach 1 - dung @Controller
@Controller
@RequestMapping(path = "home")
public class HomePageController {
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String HomePage() {
        return "Home/MainPage/HomePage";
    }
	
	@GetMapping("/lienhe")
    public String contact() {
        return "Home/MainPage/Contact";
    }
	
	@GetMapping("/donghonam")
    public String malewatch() {
        return "Home/MainPage/MaleWatch";
    }

	@GetMapping("/donghonu")
    public String femalewatch() {
        return "Home/MainPage/FemaleWatch";
    }
	
	@GetMapping("/chitietsanpham")
    public String detail() {
        return "Home/MainPage/DetailProduct";
    }
	
	@GetMapping("/giohang")
    public String card() {
        return "Home/MainPage/Card";
	}
	
	@GetMapping("/giohang/thanhtoan")
    public String payment() {
        return "Home/MainPage/Payment";
	}
	
	@GetMapping("/giohang/thanhtoan/camon")
    public String thankyou() {
        return "Home/MainPage/Thankyou";
	}
    
	@GetMapping("/thongtin")
    public String thongtin() {
        return "Home/MainPage/Infor";
	}
	
	@GetMapping("/thongtin/taikhoan")
    public String taikhoan() {
        return "Home/MainPage/Account";
	}
	
	
	
}

// Cach 2 - dung RestController
/*
@RestController()
public class HomePageController {
	@GetMapping(value = "/welcome")
	public String homePage() {
		return "welcome!";
	}
}
*/
