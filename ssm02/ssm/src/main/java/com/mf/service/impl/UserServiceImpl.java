package com.mf.service.impl;

import com.mf.dao.UserMapper;
import com.mf.entity.User;
import com.mf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUserAndRoles(String uname, Integer currentPage, Integer pageSize) {
        return userMapper.getAllUserAndRoles(uname, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public int getUserCount(String name) {
        return userMapper.getUserCount(name);
    }

    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }

    //删除
    public void deleteUser(Integer uid) {
        userMapper.deleteUser(uid);
    }

    //根据id查询用户
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    //修改用户信息
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    //新增用户
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    //根据姓名查用户
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<User> getUserByIsAlive(String uname, Integer currentPage, Integer pageSize) {
        return userMapper.getUserByIsAlive(uname, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public void approveUser(Integer uid) {
        userMapper.approveUser(uid);
    }

    @Override
    public int getUserCountIsAlive(String name) {
        return userMapper.getUserCountIsAlive(name);
    }
}
