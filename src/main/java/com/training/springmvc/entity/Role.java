package com.training.springmvc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Long roleId;
    private String roleName;
    private List<User> users;
}
