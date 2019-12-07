package com.example.demo.controller;


import com.example.demo.dao.UserDao;
import com.example.demo.dto.IdDto;
import com.example.demo.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Liyong
 * @version 1.0
 * @date 2019/12/6 11:14 PM
 */
@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/getUserList", method=RequestMethod.POST)
    public List<User> listAll() {
        return userDao.listAll();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/postUser", method=RequestMethod.POST)
    public Boolean postUser(@RequestBody User user) {
        userDao.insertUser(user);
        return Boolean.TRUE;
    }

    @ApiOperation(value="获取用户详细信息", notes="根据用户id来获取用户详细信息")
    @RequestMapping(value="/getUser", method=RequestMethod.POST)
    public User getUser(@RequestBody IdDto idDto) {
        return userDao.getUserById(idDto.getId());
    }


    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="/deleteUserById", method=RequestMethod.POST)
    public Boolean deleteUserById(@RequestBody IdDto idDto) {
        userDao.deleteUserById(idDto.getId());
        return Boolean.TRUE;
    }
}