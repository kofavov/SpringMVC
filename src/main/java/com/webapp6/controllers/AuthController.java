package com.webapp6.controllers;

import com.webapp6.models.User;
import com.webapp6.service.UserService;
import com.webapp6.util.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    @GetMapping("/sign_up")
    public String getSignUp(Model model){
        model.addAttribute("user", new User());
        return "/auth/sign_up";
    }
    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/auth/sign_up";
        }
        userService.add(user);
        return "redirect:/users";
    }

    @RequestMapping("/login")
    public String login() {
        return "auth/sign_in";
    }
}
