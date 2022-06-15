package com.mf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer uid;
    private String uname;
    private String telephone;
    private String password;
    private String realName;
    private String address;
    private Integer isAlive;
    private Date createTime;
    private Integer rid;
    private Roles roles;
}
