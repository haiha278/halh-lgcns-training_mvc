package com.training.springmvc.service.userService;

import com.training.springmvc.dto.userDTO.GetAllUserDTO;
import com.training.springmvc.dto.userDTO.LoginDTO;
import com.training.springmvc.dto.userDTO.RegisterDTO;
import com.training.springmvc.dto.userDTO.UpdateUserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<GetAllUserDTO> findAll();

    LoginDTO login(String username);

    int addUser(RegisterDTO registerDTO);

    int deleteUserByUsername(String username);

    UpdateUserDTO getUserInfoToUpdateByUsername(String username);

    int updateByUsername(UpdateUserDTO updateUserDTO);
}
