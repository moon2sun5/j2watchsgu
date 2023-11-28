package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.ChangePassword;
import com.sgu.j2watch.entities.Register;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.serviceImpl.AccountServiceImpl;
import com.sgu.j2watch.serviceImpl.CustomUserDetailService;
import com.sgu.j2watch.services.AccountService;

import ch.qos.logback.core.joran.conditional.IfAction;
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
	private AccountService accountService;
    
    
    @GetMapping("/dangnhap")
    public String dangnhap(Model model) {
    	Account account = new Account();   	
    	model.addAttribute("account", account);
    	return "Home/MainPage/HomePage";
    }
    
    
    @PostMapping("/dangnhap")
    public String login(){
    	System.out.println("hellooooo");
    	return "redirect:/admin";
    }
    
 
 // Sửa tài khoản bên trang home
    @GetMapping("/thongtin/taikhoan")
    public String editTaikhoan(Model model){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	String username = authentication.getName();
    	int id_account = accountService.checkAccount(username);
    	if (id_account > 0) {
    		Optional<Account> accountOptional = accountRepository.findById(id_account);
    		Account account = accountOptional.get();
//    		Account newAccount = new Account();
//    		model.addAttribute("newAccount", newAccount);
 
            model.addAttribute("account", account);
            return "Home/MainPage/Account";
        }
    	else {
			return "redirect:/home/dangnhap";
		}
    }
    @PostMapping("/thongtin/taikhoan")
    public String saveTaikhoan(Account account, RedirectAttributes re, HttpServletRequest request) {
    	String name = account.getUser_name();
    	int user_id = account.getUser_id();
    	
//    	System.out.println(name);
    	
		if(accountService.checkUsernameEdit(name, user_id)) {
			System.out.println(user_id);
			account.setStatus(1);
			
			accountRepository.save(account);
			re.addFlashAttribute("message", "Cập nhật thông tin tài khoản thành công");
			return "redirect:/home/thongtin/taikhoan";   			
		}
    	else {
    		re.addFlashAttribute("taikhoan", "Tên tài khoản đã tồn tại, vui lòng thử lại");
    		return "redirect:/home/thongtin/taikhoan";
		}

    }
    
 // Sửa thông tin người dùng bên trang home
    @GetMapping("/thongtin")
    public String editThontin(Model model){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	int id_account = accountService.checkAccount(username);
    	if (id_account > 0) {
    		Optional<Account> accountOptional = accountRepository.findById(id_account);
    		Account account = accountOptional.get();
    		int id_user = account.getUser_id();
    		Optional<User> userOptional = userRepository.findById(id_user);
    		User user = userOptional.get();
            model.addAttribute("user", user);
            return "Home/MainPage/Infor";
        }
    	else {
			return "redirect:/home/dangnhap";
		}
    }
    
    @PostMapping("/thongtin")
    public String save(User user, RedirectAttributes re) {
    	user.setType(2);
    	user.setRole_id(14);
    	userRepository.save(user);
    	re.addFlashAttribute("message", "Cập nhật thông tin người dùng thành công");
    	return "redirect:/home/thongtin";
    		  	
    }
        
}
