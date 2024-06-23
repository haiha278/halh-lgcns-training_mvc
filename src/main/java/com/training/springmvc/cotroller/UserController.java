package com.training.springmvc.cotroller;

import com.training.springmvc.dto.userDTO.UpdateUserDTO;
import com.training.springmvc.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"username", "role"})
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/update-user")
    public String showUpdateUserPage(Model model, @RequestParam("username") String username) {
        UpdateUserDTO updateUserDTO = userService.getUserInfoToUpdateByUsername(username);
        model.addAttribute("userInfo", updateUserDTO);
        return "update-user";
    }

    @PostMapping("/update-user")
    public String updateUser(@RequestParam("updateUserDTO") UpdateUserDTO updateUserDTO, Model model) {
        int result = userService.updateByUsername(updateUserDTO);
        if (result == 1) {
            return "redirect:/user-list";
        } else {
            model.addAttribute("errorMessage", "Register failed");
            return "update-user";
        }
    }
}
