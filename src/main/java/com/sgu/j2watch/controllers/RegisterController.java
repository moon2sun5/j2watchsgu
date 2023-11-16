package com.sgu.j2watch.controllers;

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
public class RegisterController {
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
    
    @GetMapping("/dangky")
    public String dangky(Model model, HttpServletRequest request) {
    	String currentLink = request.getRequestURI();
    	Register register = new Register();
    	register.setUser(new User());
		register.setAccount(new Account());
    	model.addAttribute("register", register);
//    	System.out.println(currentLink);
//      return "forward:/home/donghonam" ;
        return "Home/MainPage/HomePage";
//    	return "success";
    }
    
    @PostMapping("/dangky")
    public String register(@ModelAttribute("register")Register register, RedirectAttributes re){
    	String user_name = register.getAccount().getUser_name();
    	if(accountServiceImpl.checkUsername(user_name)) {
    		register.getUser().setType(2);
    		register.getUser().setRole_id(14);
    		userRepository.save(register.getUser());
    		register.getAccount().setUser_id(register.getUser().getId_user());
    		register.getAccount().setStatus(1);
    		accountRepository.save(register.getAccount());
    		return "redirect:/home";
    	}
    	else {
    		re.addFlashAttribute("message", "Tên tài khoản đã tồn tại, vui lòng thử tên khác");
    		return "redirect:/home/dangky";
		}
    }
}
