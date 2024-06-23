package com.training.springmvc.cotroller;

import com.training.springmvc.dto.userDTO.LoginDTO;
import com.training.springmvc.dto.userDTO.RegisterDTO;
import com.training.springmvc.service.userService.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"username", "role"})
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginRequest(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        LoginDTO loginDTO = userService.login(username);
        if (loginDTO != null && loginDTO.getPassword().equals(password)) {
            model.addAttribute("username", loginDTO.getUsername());
            model.addAttribute("role", loginDTO.getRole());
            return "redirect:/user-list";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("registerDTO") RegisterDTO registerDTO, Model model) {
        int result = userService.addUser(registerDTO);
        if (result == 1) {
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", "Register failed");
            return "register";
        }
    }
}
