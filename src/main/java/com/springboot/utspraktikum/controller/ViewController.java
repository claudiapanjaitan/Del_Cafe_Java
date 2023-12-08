package com.springboot.utspraktikum.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ViewController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "login";
	}
	
	@RequestMapping("/products")
	public String products() {
		return "products/index";
	}
	
}