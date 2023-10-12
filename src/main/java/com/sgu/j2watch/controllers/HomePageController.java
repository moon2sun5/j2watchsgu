package com.sgu.j2watch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Cach 1 - dung @Controller
@Controller()
public class HomePageController {
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public String homePage() {
		return "welcome! J2Watch again";
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
