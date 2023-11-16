package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private RoleRepository roleRepository;
    
	@GetMapping("/qlthongtin")
    public String qlthongtin(Model model) {
    	model.addAttribute("listType", typeRepository.findAll());   	
    	model.addAttribute("listUser", userRepository.findAll());
    	model.addAttribute("listRole", roleRepository.findAll());
        return "Admin/FormManager/M_Thongtin";
    }
    
    @GetMapping("/qlthongtin/addthongtin")
    public String addthongtin(Model model) {
    	model.addAttribute("listType", typeRepository.findAll());
    	model.addAttribute("listRole", roleRepository.findAll());
    	User user = new User();
    	model.addAttribute("user", user);
        return "Admin/FormAdd/A_Thongtin";
    }
    @PostMapping("/qlthongtin/addthongtin")
    public String saveThongtin(User user) {
    	userRepository.save(user);
    	return "redirect:/admin/qlthongtin";
    }
    @GetMapping("/qlthongtin/delete/{id}")
    public String deleteThongtin(@PathVariable("id") Integer id) {
    	userRepository.deleteById(id);
    	return "redirect:/admin/qlthongtin";
    }
    @GetMapping("/qlthongtin/edit/{id}")
    public String editThongtin(@PathVariable("id") Integer id, Model model){
    	model.addAttribute("listType", typeRepository.findAll());   	
    	model.addAttribute("listUser", userRepository.findAll());
    	model.addAttribute("listRole", roleRepository.findAll());
    	
    	Optional<User> userOptional = userRepository.findById(id);
    	User user = userOptional.get();    	
    	model.addAttribute("user", user);
    	
    	return "Admin/FormManager/M_Thongtin";
    }
    
    @PostMapping("/qlthongtin/saveThongtin")
    public String save( Integer id, User user) {
    	int type = user.getType();
    	if(type == 2) {
    		user.setRole_id(14);
    		userRepository.save(user);
    		return "redirect:/admin/qlthongtin";
    	}
    	else {
    		userRepository.save(user);
    		return "redirect:/admin/qlthongtin";
    	}  	  	
    }

}
