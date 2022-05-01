package com.pojo;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String phone;//电话
    private String name;//姓名
    private String password;//密码
    private char sex;//性别
    private int age;//年龄
    private String address;//地址
    private int professionalId;//职称id

    public Teacher() {
    }

    public Teacher(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public Teacher(String phone, String name, String password, char sex, int age, String address, int professionalId) {
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.professionalId = professionalId;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPohone() {
        return phone;
    }

    public void setPohone(String pohone) {
        this.phone = pohone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    @Override
    public String toString() {
        return name + "\t" + sex + "\t" + age + "\t\t" + phone + "\t\t" + address;
    }
}
