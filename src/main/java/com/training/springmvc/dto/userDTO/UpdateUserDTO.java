package com.training.springmvc.dto.userDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateUserDTO {
    private String username;
    private String name;
    private int age;
    private String gender;
    private LocalDate dob;
}
