package com.mf.dao;

import com.mf.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //获取所有用户信息
    public List<User> getAllUserAndRoles(@Param("uname") String uname,@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    //获取用户记录数
    public int getUserCount(String name);
    //登录
    @Select("select * from user where uname = #{uname} and password = #{password} and rid = #{rid}")
    public User Login(User user);
    //删除
    @Delete("delete from user where uid = #{uid}")
    public void deleteUser(Integer uid);
    //根据id查询用户
    @Select("select * from user where uid = #{uid}")
    public User getUserById(Integer id);
    //修改用户信息
    @Update("update user set uname = #{uname},telephone = #{telephone},password = #{password},realName = #{realName},address = #{address},createTime = #{createTime},rid = #{rid} where uid = #{uid}")
    public void updateUserById(User user);
    //新增用户
    @Insert("insert into user (uname,telephone,password,realName,address,isAlive,createTime,rid) " +
            " values (#{uname},#{telephone},#{password},#{realName},#{address},#{isAlive},#{createTime},#{rid})")
    public void addUser(User user);
    //根据姓名查用户
    @Select("select * from user where uname = #{uname}")
    public User getUserByName(String name);
    //查询未审批的用户
    public List<User> getUserByIsAlive(@Param("uname") String uname,@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    //提交审批
    @Update("update user set isAlive = 1 where uid = #{uid}")
    public void approveUser(Integer uid);
    //统计
    public int getUserCountIsAlive(String name);
}
