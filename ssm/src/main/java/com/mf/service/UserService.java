package com.mf.service;

import com.mf.entity.User;

import java.util.List;

public interface UserService {

    //获取所有用户信息
    public List<User> getAllUserAndRoles(String uname,Integer currentPage,Integer pageSize);
    //获取用户记录数
    public int getUserCount(String name);
    //登录
    public User Login(User user);
    //删除
    public void deleteUser(Integer uid);
    //根据id查询用户
    public User getUserById(Integer id);
    //修改用户信息
    public void updateUserById(User user);
    //新增用户
    public void addUser(User user);
    //根据姓名查用户
    public User getUserByName(String name);
}
