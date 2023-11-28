package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Register;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.serviceImpl.AccountServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "home")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
	private RoleRepository roleRepository;
    @Autowired
	private AccountRepository accountRepository;
    @Autowired
	private AccountServiceImpl accountServiceImpl;
    
    @GetMapping("/dangnhap")
    public String dangnhap(Model model) {
    	Account account = new Account();   	
    	model.addAttribute("account", account);
    	return "Home/MainPage/HomePage";
    }
    
    @PostMapping("/dangnhap")
    public String login(Account account, RedirectAttributes re){
    	String usernameForm = account.getUser_name();
    	String passwordForm = account.getPassword();
    	
//    	System.out.println(password);
//    	System.out.println(status);
    	if(!accountServiceImpl.checkUsername(usernameForm)) {
    		int checkacc = accountServiceImpl.checkAccount(usernameForm);
        	Optional<Account> acc = accountServiceImpl.findById(checkacc);
        	Account newAccount = acc.get(); 
        	int status = newAccount.getStatus();
        	String password = newAccount.getPassword();
        	if(status == 1) {
        		if(passwordForm.equals(password)) {
        			return "redirect:/home";    			
        		}
        		else {
        			re.addFlashAttribute("matkhau", "Mật khẩu không đúng, vui lòng thử lại");
        			return "redirect:/home/dangnhap";
        		}        		
        	}
        	else {
        		re.addFlashAttribute("status", "Tài khoản đã tắt hoạt động, vui lòng thử lại");
    			return "redirect:/home/dangnhap";
			}
    	}
    	else {
    		re.addFlashAttribute("taikhoan", "Tên đăng nhập không đúng, vui lòng thử lại");
    		return "redirect:/home/dangnhap";
		}
    }
}
