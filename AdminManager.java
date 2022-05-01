package com.pojo;

import java.io.Serializable;

public class AdminManager implements Serializable {
    private String phone;
    private String name;//管理员名
    private String password;//密码
    private int isUse;//账户是否启用 1为启用

    public AdminManager() {
    }

    public AdminManager(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public AdminManager(String phone, String name, String password, int isUse) {
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.isUse = isUse;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return phone + "\t\t" + name;
    }
}
