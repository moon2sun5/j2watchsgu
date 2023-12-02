package com.sgu.j2watch.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.sgu.j2watch.serviceImpl.UserServiceImpl;
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
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/qlthongtin")
    public String qlthongtin(Model model, @Param("keyword") String keyword, @RequestParam(name = "type", required = false) Integer type,
            @RequestParam(name = "role", required = false) Integer role) {
        model.addAttribute("listType", typeRepository.findAll());
        model.addAttribute("listRole", roleRepository.findAll());
        model.addAttribute("list_Type", 0); 
    	model.addAttribute("list_Role", 0);
        List<User> list = new ArrayList();
        if(keyword != null) {
			list.addAll(this.userServiceImpl.searchNameOrEmail(keyword));
			model.addAttribute("listUser", list); 
		}
        else if(type != null && role != null) {
        	list.addAll(this.userServiceImpl.searchTypeAndRole(type,role));
        	model.addAttribute("list_Type", type); 
        	model.addAttribute("list_Role", role); 
			model.addAttribute("listUser", list); 
        }
        else if(type != null){
        	list.addAll(this.userServiceImpl.searchTypeAndRole(type,null));
        	model.addAttribute("list_Type", type); 
			model.addAttribute("listUser", list); 
        }
        else if(role != null){
        	list.addAll(this.userServiceImpl.searchTypeAndRole(null,role));
        	model.addAttribute("list_Role", role); 
			model.addAttribute("listUser", list); 
        }
        else {
        	model.addAttribute("listUser", userRepository.findAll());
        }
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
    	Iterable<Account> accIterable = accountRepository.findAll();
    	for(Account acc : accIterable) {
    		if(acc.getUser_id() == id) {
    			accountRepository.deleteById(acc.getId_account());    			
    		}
    	}
        userRepository.deleteById(id);
        return "redirect:/admin/qlthongtin";
    }

    @GetMapping("/qlthongtin/edit/{id}")
    public String editThongtin(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listType", typeRepository.findAll());
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listRole", roleRepository.findAll());

        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        model.addAttribute("user", user);

        return "Admin/FormManager/M_Thongtin";
    }

    @PostMapping("/qlthongtin/saveThongtin")
    public String save(Integer id, User user) {
        int type = user.getType();
        if (type == 2) {
            user.setRole_id(14);
            userRepository.save(user);
            return "redirect:/admin/qlthongtin";
        } else {
            userRepository.save(user);
            return "redirect:/admin/qlthongtin";
        }
    }
}
