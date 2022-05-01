package com.control;

import com.pojo.ChangeCourse;
import com.pojo.Course;
import com.pojo.Professional;
import com.pojo.Teacher;
import com.untils.Myuntil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherControl {
    public static void teacherControl(List<Teacher> teacherList, List<ChangeCourse> changeCourseList,
                                      List<Course> courseList, List<Professional> professionalList, String phone) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------------------------");
            System.out.println("1,查看个人信息");
            System.out.println("2,查看课程信息");
            System.out.println("3,申请课程调整");
            System.out.println("4,查看课程调整申请");
            System.out.println("5,返回上一级");
            System.out.println("-----------------------------------");
            int choose1 = scanner.nextInt();
            if (choose1 == 1) {
                System.out.println("姓名\t性别\t年龄\t\t电话\t\t地址\t\t职称");
                Basic.showTeacher(teacherList, professionalList, phone);
                System.out.println("是否修改个人信息：（1，是 2，否）");
                if (scanner.nextInt() == 1) {
                    updataTeacher(teacherList, professionalList, phone);
                }
            }
            if (choose1 == 2) {
                Basic.showCourse(courseList, phone);
            }
            if (choose1 == 3) {
                System.out.print("请输入要申请的课程名：");
                String name = scanner.next();
                Basic.applyCourse(changeCourseList, phone, name);
            }
            if (choose1 == 4) {
                System.out.println("姓名\t性别\t年龄\t\t电话\t\t地址\t\t课程名\t是否通过\t通过时间");
                Basic.showCangeCourseAndInfo(changeCourseList, teacherList, phone);
            }
            if (choose1 == 5) {
                flag = false;
            }
        }
    }

    public static boolean addTeacher(List<Teacher> list, List<Professional> professionalList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.print("请输入性别：");
        char sex = scanner.next().charAt(0);
        System.out.print("请输入年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入电话：");
        String phone = scanner.next();
        System.out.print("请输入地址：");
        String address = scanner.next();
        int proId = -1;
        do {
            System.out.println("本校的职称列表如下：");
            System.out.println("------------------");
            for (Professional p : professionalList) {
                System.out.println(p.getName());
            }
            System.out.println("------------------");
            System.out.print("请输入职称：");
            String professional = scanner.next();
            for (Professional p : professionalList) {
                if (p.getName().equals(professional)) {
                    proId = p.getId();
                }
            }
            if (proId == -1) {
                System.out.println("职称不存在，请重新输入");
            }
        } while (proId == -1);
        if (Myuntil.getByPhone(list, phone) == null) {
            list.add(new Teacher(phone, name, password, sex, age, address, proId));
            return true;
        }
        return false;
    }

    public static void updataTeacher(List<Teacher> list, List<Professional> professionalList, String phone) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.print("请输入性别：");
        char sex = scanner.next().charAt(0);
        System.out.print("请输入年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入地址：");
        String address = scanner.next();
        int proId = -1;
        do {
            System.out.print("请输入职称：");
            String professional = scanner.next();
            for (Professional p : professionalList) {
                if (p.getName().equals(professional)) {
                    proId = p.getId();
                }
            }
            if (proId == -1) {
                System.out.println("职称不存在，请重新输入");
            }
        } while (proId == -1);
        Teacher t = Myuntil.getByPhone(list, phone);
        t.setName(name);
        t.setSex(sex);
        t.setAddress(address);
        t.setAge(age);
        t.setPassword(password);
        t.setPohone(phone);
        t.setProfessionalId(proId);
    }

    public static void delete(List<Teacher> teacherList,String phone){
        Teacher delT = null;
        for (Teacher t:teacherList){
            if(t.getPohone().equals(phone)){
                delT = t;
            }
        }
        teacherList.remove(delT);
    }
}
