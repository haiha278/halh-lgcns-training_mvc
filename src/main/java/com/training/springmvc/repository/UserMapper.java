package com.training.springmvc.repository;

import com.training.springmvc.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @Select("select u.*, r.role_name from user u join role r on u.role_id = r.id")
    @ResultMap("UserResultMap")
    List<User> findAll();

//    @Select("select * from user where username =  #{username}")
//    @ResultMap("UserResultMap")
//    Optional<User> findByUsername(String username);

    @Select("select u.username, u.password, u.name, u.age, u.gender, u.dob, r.role_name from user u join role r on u.role_id = r.id where u.username =  #{username}")
    @ResultMap("UserResultMap")
    Optional<User> findByUsername(String username);


    @Insert("INSERT INTO user (username, password, name, age, gender, dob, role_id) " +
            "VALUES (#{username}, #{password}, #{name}, #{age}, #{gender}, #{dob}, #{role.roleId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);


    @Delete("DELETE From user where username = #{username}")
    int deleteUserByUsername(String username);
}
