package com.springboot.utspraktikum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("")
    public String HomePage(Model model) {
        return "home";
    }
}
