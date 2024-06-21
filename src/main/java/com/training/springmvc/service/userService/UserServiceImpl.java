package com.training.springmvc.service.userService;

import com.training.springmvc.dto.userDTO.GetAllUserDTO;
import com.training.springmvc.dto.userDTO.LoginDTO;
import com.training.springmvc.dto.userDTO.RegisterDTO;
import com.training.springmvc.entity.Role;
import com.training.springmvc.entity.User;
import com.training.springmvc.modelMapper.Mapper;
import com.training.springmvc.repository.UserMapper;
import com.training.springmvc.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Mapper mapper;

    @Autowired
    public UserServiceImpl(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<GetAllUserDTO> findAll() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper user_mapper = session.getMapper(UserMapper.class);
        List<GetAllUserDTO> getAllUserDTOList = user_mapper.findAll().stream().map(user -> {
            GetAllUserDTO getAllUserDTO = (GetAllUserDTO) mapper.mapToDTO(user, GetAllUserDTO.class);
            getAllUserDTO.setRoleName(user.getRole().getRoleName());
            return getAllUserDTO;
        }).toList();
        session.commit();
        session.close();
        return getAllUserDTOList;
    }

    @Override
    public LoginDTO findByUsername(String username) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper user_mapper = session.getMapper(UserMapper.class);
        Optional<User> optionalUser = user_mapper.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            LoginDTO loginDTO = (LoginDTO) mapper.mapToDTO(user, LoginDTO.class);
            loginDTO.setRole(user.getRole().getRoleName());
            return loginDTO;
        }
        session.commit();
        session.close();
        return null;
    }

    @Override
    public int addUser(RegisterDTO registerDTO) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper user_mapper = session.getMapper(UserMapper.class);

        User user = (User) mapper.mapToEntity(registerDTO, User.class);
        user.setAge(Period.between(registerDTO.getDob(), LocalDate.now()).getYears());

        Role role = new Role();
        role.setRoleId((long) 2);

        user.setRole(role);

        int row_effected = user_mapper.insertUser(user);
        session.commit();
        session.close();
        return row_effected;
    }

    @Override
    public int deleteUserByUsername(String username) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        UserMapper user_mapper = session.getMapper(UserMapper.class);

        int row_effected = user_mapper.deleteUserByUsername(username);

        session.commit();
        session.close();
        return row_effected;
    }
}
