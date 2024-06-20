package com.training.springmvc.cotroller;

import com.training.springmvc.dto.userDTO.GetAllUserDTO;
import com.training.springmvc.service.userService.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final HttpSession httpSession;

    @Autowired
    public AdminController(UserService userService, HttpSession httpSession) {
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/user-list")
    public String hello(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        }
        List<GetAllUserDTO> getAllUserDTOList = userService.findAll();
        model.addAttribute("allUsers", getAllUserDTOList);
        return "user-list";
    }
}
