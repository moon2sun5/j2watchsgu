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
public class RoleController {
	@Autowired
    private RoleRepository roleRepository;

    @Autowired
	private RoleServiceImpl roleServiceImpl;
    
    @GetMapping("/qlquyen")
    public String qlquyen(Model model) {
    	model.addAttribute("listRole", roleRepository.findAll());
        return "Admin/FormManager/M_Quyen";
    }
    
    @GetMapping("/qlquyen/addquyen")
    public String addquyen(Model model) {
    	model.addAttribute("listRole", roleRepository.findAll());
    	Role role = new Role();
    	model.addAttribute("role", role);
        return "Admin/FormAdd/A_Quyen";
    }
    
    @PostMapping("/qlquyen/addquyen")
    public String saveQuyen(Role role, RedirectAttributes re) {
    	String name = role.getName();
    	if(roleServiceImpl.checkQuyen(name)) {
    		roleRepository.save(role);
        	return "redirect:/admin/qlquyen";
    	}
    	else {
    		re.addFlashAttribute("message", "Quyền đã tồn tại, vui lòng thử tên khác");
    		return "redirect:/admin/qlquyen/addquyen";
		}
    }
    
    @GetMapping("/qlquyen/delete/{id}")
    public String deleteQuyen(@PathVariable("id") Integer id) {
    	roleRepository.deleteById(id);
    	return "redirect:/admin/qlquyen";
    }
    
    @GetMapping("/qlquyen/edit/{id}")
    public String editQuyen(@PathVariable("id") Integer id, Model model){
    	model.addAttribute("listRole", roleRepository.findAll());
    	Optional<Role> roleOptional = roleServiceImpl.findById(id);
    	Role role = roleOptional.get();    	
    	model.addAttribute("role", role);
    	
    	return "Admin/FormManager/M_Quyen";
    }
    
    @PostMapping("/qlquyen/saveQuyen/{id}")
    public String save(@PathVariable("id") Integer id, Role role, RedirectAttributes re) {
    	String name = role.getName();
    	if(roleServiceImpl.checkQuyen(name)) {
    		roleRepository.save(role);
        	return "redirect:/admin/qlquyen";
    	}
    	else {
    		re.addFlashAttribute("message", "Quyền đã tồn tại, vui lòng thử tên khác");
    		return "redirect:/admin/qlquyen/edit/" + id;
		}
    }

}
