package com.training.springmvc.cotroller;


import com.training.springmvc.dto.userDTO.GetAllUserDTO;
import com.training.springmvc.service.userService.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-list")
    public String hello(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("username") == null) {
            return "redirect:/login";
        }
        List<GetAllUserDTO> getAllUserDTOList = userService.findAll();
        model.addAttribute("allUsers", getAllUserDTOList);
        return "user-list";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam("username") String username, Model model) {
        int row_affected = userService.deleteUserByUsername(username);
        if (row_affected == 1) {
            model.addAttribute("message", "Delete User Successfully");
            return "redirect:/user-list";
        } else {
            model.addAttribute("message", "Delete User Failed");
            return "redirect:/user-list";
        }
    }
}
