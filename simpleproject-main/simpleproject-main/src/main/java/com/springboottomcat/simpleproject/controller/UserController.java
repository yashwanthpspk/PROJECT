package com.springboottomcat.simpleproject.controller;

import com.springboottomcat.simpleproject.dto.UserDto;
import com.springboottomcat.simpleproject.model.User;
import com.springboottomcat.simpleproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUserForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user-form";
    }

    @PostMapping("/users")
    public String saveUser(@Valid @ModelAttribute("userDto") UserDto userDto, 
                          BindingResult result, 
                          RedirectAttributes redirectAttributes) {
        
        // Check if email already exists
        if (userService.emailExists(userDto.getEmail())) {
            result.rejectValue("email", "error.user", "Email already exists");
        }
        
        if (result.hasErrors()) {
            return "user-form";
        }
        
        // Convert DTO to entity and save
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getPhone());
        userService.saveUser(user);
        
        redirectAttributes.addFlashAttribute("successMessage", "User registered successfully!");
        return "redirect:/";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }
}
