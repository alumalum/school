package com.test;

import com.control.AdminControl;
import com.control.Basic;
import com.control.TeacherControl;
import com.pojo.*;
import com.untils.Myuntil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Myuntil myuntil = new Myuntil();
        String path = "c:\\新建文件夹 (3)\\";//文件路径 例如：c:\新建文件夹\
        myuntil.init(path);//初始化一个超级管理员和一些默认职称。
        ArrayList<Teacher> teacherList = null;
        ArrayList<ChangeCourse> changeCourseList = null;
        ArrayList<Course> courseList = null;
        if (new File(path + "teacherList.txt").exists()) {
            teacherList = myuntil.readFile(path + "teacherList.txt");
        }else {
            teacherList = new ArrayList<>();
        }
        if (new File(path + "changeCourseList.txt").exists()) {
            changeCourseList = myuntil.readFile(path + "changeCourseList.txt");
        }else {
            changeCourseList = new ArrayList<>();
        }
        if (new File(path + "courseList.txt").exists()) {
            courseList = myuntil.readFile(path + "courseList.txt");
        }else {
            courseList = new ArrayList<>();
        }
        ArrayList<Professional> professionalList = myuntil.readFile(path + "professionalList.txt");
        ArrayList<AdminManager> adminList = myuntil.readFile(path + "adminList.txt");
        String loginAdminId = null;
        String loginTeacherId = null;
        while (flag) {
            System.out.println("------------欢迎使用本系统-----------");
            System.out.println("1,登录");
            System.out.println("2,注册");
            System.out.println("3,退出");
            System.out.println("----------------------------------");
            System.out.print("请选择：");
            int choose1 = scanner.nextInt();
            if (choose1 == 1) {
                if (loginAdminId == null || loginTeacherId == null) {
                    System.out.println("-----------------------------------");
                    System.out.println("1,管理员登录");
                    System.out.println("2,老师登录");
                    System.out.println("----------------------------------");
                    System.out.print("请选择：");
                    int choose12 = scanner.nextInt();
                    System.out.print("请输入手机号：");
                    String phone = scanner.next();
                    System.out.print("请输入密码：");
                    String password = scanner.next();
                    if (choose12 == 1) {
                        AdminManager adminManager = new AdminManager(phone, password);
                        if (Basic.Login(adminList, adminManager)) {
                            loginAdminId = phone;
                            loginTeacherId = "";
                            System.out.println("登录成功，管理员：" + loginAdminId + ",欢迎你!!");
                            AdminControl.adminControl(adminList,teacherList,changeCourseList,
                                    courseList,professionalList,phone);
                        } else {
                            System.out.println("登录失败,账户可能未启用（需要联系超级管理员）或者账户名或者密码错误");
                        }
                    } else if (choose12 == 2) {
                        Teacher teacher = new Teacher(phone, password);
                        if (Basic.Login(teacherList, teacher)) {
                            loginTeacherId = phone;
                            loginAdminId = "";
                            System.out.println("登录成功,老师：" + phone + "欢迎你!!");
                            TeacherControl.teacherControl(teacherList, changeCourseList,
                                    courseList, professionalList, loginTeacherId);
                        } else {
                            System.out.println("登录失败");
                        }
                    }
                } else {
                    String num = loginAdminId == null ? loginTeacherId : loginAdminId;
                    System.out.println("你已经成功登录了，登录账户为：" + num);
                }
            } else if (choose1 == 2) {
                System.out.println("-----------------------------------");
                System.out.println("1,管理员注册");
                System.out.println("2,老师注册");
                System.out.println("----------------------------------");
                System.out.print("请选择：");
                int choose22 = scanner.nextInt();
                if (choose22 == 1) {
                    if (AdminControl.addAdmin(adminList)) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("该手机号已经注册");
                    }
                }
                if (choose22 == 2) {
                    if (TeacherControl.addTeacher(teacherList, professionalList)) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("该手机号已经注册");
                    }
                }
            } else if (choose1 == 3) {
                myuntil.writeFile(path + "adminList.txt", adminList);
                myuntil.writeFile(path + "changeCourseList.txt", changeCourseList);
                myuntil.writeFile(path + "courseList.txt", courseList);
                myuntil.writeFile(path + "professionalList.txt", professionalList);
                myuntil.writeFile(path + "teacherList.txt", teacherList);
                System.out.println("-----------------------------------");
                System.out.println("1，退出系统");
                System.out.println("2，退出登录");
                System.out.println("-----------------------------------");
                int choose32 = scanner.nextInt();
                if (choose32 == 1) {
                    flag = false;
                } else if (choose32 == 2) {
                    loginAdminId = null;
                    loginTeacherId = null;
                }
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}
