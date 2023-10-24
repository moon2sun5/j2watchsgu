package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.repositories.CategoryRepository;

// Cach 1 - dung @Controller
@Controller
//@RestController
public class HomePageController {
	@RequestMapping("/admin")
	public String HomePage() {
		return "Admin/FormManager/MainPage";
	}

	@RequestMapping("/admin/qlthongtin")
	public String qlthongtin() {
		return "Admin/FormManager/M_Thongtin";
	}

	@RequestMapping("/admin/qltaikhoan")
	public String qltaikhoan() {
		return "Admin/FormManager/M_Taikhoan";
	}

	@RequestMapping("/admin/qlsanpham")
	public String qlsanpham() {
		return "Admin/FormManager/M_Sanpham";
	}

	@RequestMapping("/admin/qlhoadon")
	public String qlhoadon() {
		return "Admin/FormManager/M_Hoadon";
	}

	@RequestMapping("/admin/qlnhaphang")
	public String qlnhaphang() {
		return "Admin/FormManager/M_Nhaphang";
	}

	@RequestMapping("/admin/qlbaocao")
	public String qlbaocao() {
		return "Admin/FormManager/M_Baocao";
	}

	@RequestMapping("/admin/qlnhacungcap")
	public String qlnhacungcap() {
		return "Admin/FormManager/M_Nhacungcap";
	}

	@RequestMapping("/admin/qlvoucher")
	public String qlvoucher() {
		return "Admin/FormManager/M_Voucher";}

		@RequestMapping("/admin/qlquyen")
		public String qlquyen() {
			return "Admin/FormManager/M_Quyen";
		}

		@RequestMapping("/admin/qlthongtin/addthongtin")
		public String addthongtin() {
			return "Admin/FormAdd/A_Thongtin";
		}

		@RequestMapping("/admin/qltaikhoan/addtaikhoan")
		public String addtaikhoan() {
			return "Admin/FormAdd/A_Taikhoan";
		}

		@RequestMapping("/admin/qlsanpham/addsanpham")
		public String addsanpham() {
			return "Admin/FormAdd/A_Sanpham";
		}

		@RequestMapping("/admin/qlnhaphang/addnhaphang")
		public String addnhaphang() {
			return "Admin/FormAdd/A_Nhaphang";
		}

		@RequestMapping("/admin/qlnhacungcap/addnhacungcap")
		public String addnhacungcap() {
			return "Admin/FormAdd/A_Nhacungcap";
		}

		@RequestMapping("/admin/qlvoucher/addvoucher")
		public String addvoucher() {
			return "Admin/FormAdd/A_Voucher";
		}

		@RequestMapping("/admin/qlquyen/addquyen")
		public String addquyen() {
			return "Admin/FormAdd/A_Quyen";
		}


		@Autowired
		private CategoryRepository categoryRepository;

		@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Optional<Category> category(@PathVariable int id) {
			return categoryRepository.findById(id);
		}

		@RequestMapping(value = "/category", method = RequestMethod.GET)
		@ResponseBody
		public Iterable<Category> getAllCategory() {
			return categoryRepository.findAll();
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