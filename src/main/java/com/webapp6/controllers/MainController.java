package com.webapp6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("msg","Hello!");
        return "/index";
    }
}
