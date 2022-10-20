package com.indocyber.penjualan.controller;

import com.indocyber.penjualan.dto.users.RegisterDTO;
import com.indocyber.penjualan.service.abstraction.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/loginForm")
    public String loginForm(Model model) {
        return "users/login-form";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(Model model) {
        return "users/access-denied";
    }

    @GetMapping("/registerForm")
    public String registerForm(Model model) {
        RegisterDTO dto = new RegisterDTO();
        model.addAttribute("users", dto);
        return "users/register-form";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("users") RegisterDTO dto,
                           BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "users/register-form";
        }
        service.registerAccount(dto);
        return "redirect:/user/loginForm";
    }
}
