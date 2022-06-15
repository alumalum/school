package com.mf.service;

import com.mf.entity.User;

import java.util.List;

public interface UserService {

    //获取所有用户信息
    public List<User> getAllUserAndRoles(String uname, Integer currentPage, Integer pageSize);

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

    //查询未审批的用户
    public List<User> getUserByIsAlive(String uname, Integer currentPage, Integer pageSize);

    //提交审批
    public void approveUser(Integer uid);

    public int getUserCountIsAlive(String name);
}
