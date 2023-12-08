package com.springboot.utspraktikum.controller;

import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.utspraktikum.model.User;
import com.springboot.utspraktikum.service.UserService;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }
   
    @GetMapping("/register")
    public String registerPage(Model model) {
        return "register";
    }
    
    @PostMapping("/registers")
    public String registerUser(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {
        
        userService.addUser(user);

        return "redirect:/products";
    }
    

    @PostMapping("/login") // Ganti dengan rute yang sesuai
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        // Periksa apakah kombinasi username dan password cocok
        List<User> users = userService.getUserByUsername(username);

        if (!users.isEmpty()) {
            User user = users.get(0);

            // Periksa kesesuaian kata sandi
            if (user.getPassword().equals(password)) {
                // Login berhasil
                session.setAttribute("loggedInUser", user); // Simpan pengguna yang sudah masuk dalam sesi

                // Redirect ke halaman lain setelah login berhasil
                return "redirect:/products"; // Ganti "/dashboard" dengan URL tujuan yang sesuai
            }
        }

        return "login"; // Kembali ke halaman login dengan pesan kesalahan
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Hapus sesi pengguna yang telah login
        session.removeAttribute("loggedInUser");
        return "redirect:/users/login";
    }



}
