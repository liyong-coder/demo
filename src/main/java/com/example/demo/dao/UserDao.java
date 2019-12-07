package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Liyong
 * @version 1.0
 * @date 2019/12/6 11:14 PM
 */
@Mapper
public interface UserDao {

    User  getUserById(Long id);

    void insertUser(User user);

    void deleteUserById(Long id);

    List<User> listByUsername(String username);

    List<User> listAll();

}
