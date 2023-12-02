package com.sgu.j2watch.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.CategoryRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.serviceImpl.AccountServiceImpl;
import com.sgu.j2watch.serviceImpl.RoleServiceImpl;
import com.sgu.j2watch.services.RoleService;
import com.sgu.j2watch.services.TypeService;
import com.sgu.j2watch.services.UserService;


@Controller
@RequestMapping(path = "admin")
public class AccountController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private UserService userService;

    @GetMapping("/qltaikhoan")
    public String qltaikhoan(Model model, @Param("keyword") String keyword) {
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listType", typeRepository.findAll());
        List<Account> list = new ArrayList();
        if(keyword != null) {
			list.addAll(this.accountServiceImpl.searchNameLogin(keyword));
			model.addAttribute("listAcc", list); 
		}
        else {
        	model.addAttribute("listAcc", accountRepository.findAll());        	
        }
        return "Admin/FormManager/M_Taikhoan";
    }

    // Thêm tài khoản
    @GetMapping("/qltaikhoan/addtaikhoan")
    public String addtaikhoan(Model model) {
//    	model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listAcc", accountRepository.findAll());
        model.addAttribute("listUser", userService.find());
        Account account = new Account();
        account.setStatus(1);
        model.addAttribute("account", account);
        return "Admin/FormAdd/A_Taikhoan";
    }

    @PostMapping("/qltaikhoan/addtaikhoan")
    public String saveTaikhoan(Account account, RedirectAttributes re) {
        String user_name = account.getUser_name();
        if (accountServiceImpl.checkUsername(user_name)) {
            accountRepository.save(account);
            return "redirect:/admin/qltaikhoan";
        } else {
            re.addFlashAttribute("message", "Tên tài khoản đã tồn tại, vui lòng thử tên khác");
            return "redirect:/admin/qltaikhoan/addtaikhoan";
        }
    }

    // On / Off trạng thái
    @GetMapping("/qltaikhoan/status/{id}")
    public String saveStatus(@PathVariable("id") Integer id) {
        Optional<Account> accOptional = accountServiceImpl.findById(id);
        Account acc = accOptional.get();
        int status = acc.getStatus();
        if (status != 1) {
            acc.setStatus(1);
            accountRepository.save(acc);
            return "redirect:/admin/qltaikhoan";
        } else {
            acc.setStatus(0);
            accountRepository.save(acc);
            return "redirect:/admin/qltaikhoan";
        }
    }


    // Xóa tài khoản
    @GetMapping("/qltaikhoan/delete/{id}")
    public String deleteTaikhoan(@PathVariable("id") Integer id) {
        accountRepository.deleteById(id);
        return "redirect:/admin/qltaikhoan";
    }


    // Sửa tài khoản
    @GetMapping("/qltaikhoan/edit/{id}")
    public String editTaikhoan(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listAcc", accountRepository.findAll());
        Optional<Account> accOptional = accountServiceImpl.findById(id);
        Account acc = accOptional.get();
        model.addAttribute("account", acc);

        return "Admin/FormManager/M_Taikhoan";
    }

    @PostMapping("/qltaikhoan/saveTaikhoan/{id}")
    public String save(@PathVariable("id") Integer id, Account account, RedirectAttributes re) {
        String name = account.getUser_name();
        int user_id = account.getUser_id();
        if (accountServiceImpl.checkUsernameEdit(name, user_id)) {
            account.setStatus(1);
            accountRepository.save(account);
            return "redirect:/admin/qltaikhoan";
        } else {
            re.addFlashAttribute("message", "Tên đăng nhập đã tồn tại, vui lòng thử tên khác");
            return "redirect:/admin/qltaikhoan/edit/" + id;
        }
    }

//    // Tìm kiếm tài khoản
//    @PostMapping("/qltaikhoan/search/{input}")
//    public String search(@PathVariable("input") String input, Model model, RedirectAttributes re) {
////    	Iterable<Account> accIter = accountRepository.findAll();
//    	List<Integer> list = accountServiceImpl.search(input);
////    	model.addAttribute("listAcc", accountRepository.findAll());
////    	Optional<Account> accOptional = accountServiceImpl.findById(id);
//    	
//   
//		for(Integer newList : list) {
//			Optional<Account> accOptional = accountServiceImpl.findById(newList);
//			Account account = accOptional.get();
//		}
//	
//    	model.addAttribute("account", acc);
//    	accountRepository.deleteById(id);
//    	return "redirect:/admin/qltaikhoan";
//    }


}
