package com.sgu.j2watch.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgu.j2watch.entities.Category;
import com.sgu.j2watch.repositories.CategoryRepository;

// Cach 1 - dung @Controller
@Controller()
public class HomePageController {
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public String homePage() {
		return "welcome! J2Watch hahahahha again";
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
