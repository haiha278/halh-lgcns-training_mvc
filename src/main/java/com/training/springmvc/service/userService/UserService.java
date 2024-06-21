package com.training.springmvc.service.userService;

import com.training.springmvc.dto.userDTO.GetAllUserDTO;
import com.training.springmvc.dto.userDTO.LoginDTO;
import com.training.springmvc.dto.userDTO.RegisterDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<GetAllUserDTO> findAll();

    LoginDTO findByUsername(String username);

    int addUser(RegisterDTO registerDTO);

    int deleteUserByUsername(String username);
}
