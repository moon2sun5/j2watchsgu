package com.sgu.j2watch.controllers;


import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.sym.Name;
import com.sgu.j2watch.entities.Account;
import com.sgu.j2watch.entities.Register;
import com.sgu.j2watch.entities.Role;
import com.sgu.j2watch.entities.User;
import com.sgu.j2watch.repositories.AccountRepository;
import com.sgu.j2watch.repositories.RoleRepository;
import com.sgu.j2watch.repositories.TypeRepository;
import com.sgu.j2watch.repositories.UserRepository;
import com.sgu.j2watch.serviceImpl.AccountServiceImpl;
import com.sgu.j2watch.services.UserService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "home")
public class RegisterController {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private UserService userService;
    @Autowired
	private AccountRepository accountRepository;
    @Autowired
	private AccountServiceImpl accountServiceImpl;
    @Autowired
   	private JavaMailSender mailSender;
    
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
    
    @GetMapping("/quenmatkhau")
    public String forgot() {
        return "Home/MainPage/ForgotPassword";

    }
    @PostMapping("/quenmatkhau")
    public String processForgot(HttpServletRequest request, RedirectAttributes re) {
    	SecureRandom secureRandom = new SecureRandom();

        // Số lượng ký tự trong mã token
        int tokenLength = 40;

        // Tập hợp các ký tự có thể xuất hiện trong mã token
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // StringBuilder để lưu trữ mã token
        StringBuilder token = new StringBuilder();
        
        for (int i = 0; i < tokenLength; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            token.append(randomChar);
        }
        
    	String email = request.getParameter("email");
    	
    	System.out.println(email);
    	System.out.println(token.toString());
    	if(userService.updateResetPassword(token.toString(), email)) {
    		
    		try {
    			String resetPassword = Utility.getSiteURL(request) + "/home/datlaimatkhau?token=" + token;
				sendEmail(email, resetPassword);
				re.addFlashAttribute("message", "Chúng tôi đã gửi link đặt lại mật khẩu tới email của bạn.");
				return "redirect:/home/quenmatkhau";
			} catch (UnsupportedEncodingException | MessagingException e) {
				re.addFlashAttribute("message", "Đã xảy ra lôi khi gửi tới email của bạn.");
				return "redirect:/home/quenmatkhau";
			} 
    		
    	}
    	else {
    		
    		re.addFlashAttribute("message", "Không tìm thấy người dùng có email: " + email);
    		return "redirect:/home/quenmatkhau";
		}    	 	

    }
    
    private void sendEmail(String email, String resetPassword) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("ccontact@mywatch.com", "MyWatch Support");
		helper.setTo(email);
		
		String subject = "Đây là link để đặt lại mật khẩu";
		String content = "MyWatch xin chào, \n"
				+ "Bạn đã yêu cầu để đặt lại mật khẩu. \n"
				+ "Nhấp vào đường link bên dưới để thay đổi mật khẩu: "
				+ resetPassword 
				+ "\nMyWatch xin cảm ơn bạn đã quan tâm đến sản phẩm của cửa hàng.";
		
		helper.setSubject(subject);
		helper.setText(content);
		
		mailSender.send(message);
	}

	@GetMapping("/datlaimatkhau")
    public String reset(@RequestParam(value = "token") String token, RedirectAttributes re, Model model) {
    	User user = userService.get(token);
    	if(user == null) {
    		re.addFlashAttribute("message", "Mã Token không tồn tại");
    		return "redirect:/home/datlaimatkhau";
    	}
    	else {
			model.addAttribute("token", token);
			return "Home/MainPage/ResetPassword";
		}
//		return "Home/MainPage/ResetPassword";
    }
	
	@PostMapping("/datlaimatkhau")
    public String processReset(HttpServletRequest request, RedirectAttributes re, Model model) {
    	String token = request.getParameter("token");
    	String password = request.getParameter("newpassword");
    	User user = userService.get(token);
    	System.out.println(password);
    	System.out.println(token);
    
    	
    	if(user == null) {
    		re.addFlashAttribute("message", "Mã Token không tồn tại");
    		return "redirect:/home/datlaimatkhau";
    	}
    	else {
    		userService.updatePassword(user, password);
    		re.addFlashAttribute("message", "Bạn đã thay đổi mật khẩu thành công! Xin hãy đăng nhập lại.");
			return "redirect:/home/datlaimatkhau";
		}

    }
}
