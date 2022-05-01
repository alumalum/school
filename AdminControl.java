package com.control;

import com.pojo.*;
import com.untils.Myuntil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminControl {
    public static boolean addAdmin(List<AdminManager> adminManagerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        System.out.println("请输入手机号");
        String phone = scanner.next();
        if (Myuntil.getAdminByPhone(adminManagerList, phone) == null) {
            adminManagerList.add(new AdminManager(phone, name, password, 0));
            return true;
        }
        return false;
    }

    public static void adminControl(List<AdminManager> adminManagerList, List<Teacher> teacherList, List<ChangeCourse> changeCourseList, List<Course> courseList, List<Professional> professionalList, String phone) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("-----------------------------------");
            System.out.println("1,查看所有教师的信息及职称");
            System.out.println("2,教师的信息，职称管理");
            System.out.println("3,教师课程管理");
            System.out.println("4,职称管理");
            System.out.println("5,查看职称下所以教师信息");
            System.out.println("6,调整课程管理");
            System.out.println("7,返回上一级");
            if (phone.equals("root")) {
                System.out.println("8,审批管理员账户注册");
            }
            System.out.println("-----------------------------------");
            int choose1 = scanner.nextInt();
            if (choose1 == 1) {
                Basic.showAllTeacher(teacherList, professionalList);
            } else if (choose1 == 2) {
                Basic.showAllTeacher(teacherList, professionalList);
                System.out.print("请选择要操作的老师电话：");
                String changePhone = scanner.next();
                System.out.println("-----------------------------------");
                System.out.println("1,删除");
                System.out.println("2,修改");
                System.out.println("-----------------------------------");
                System.out.print("请选择操作：");
                int choose22 = scanner.nextInt();
                if (choose22 == 1) {
                    TeacherControl.delete(teacherList, changePhone);
                } else if (choose22 == 2) {
                    TeacherControl.updataTeacher(teacherList, professionalList, changePhone);
                } else {
                    System.out.println("输入错误");
                }
            } else if (choose1 == 3) {
                Basic.showAllCourse(courseList);
                System.out.println("-----------------------------------");
                System.out.println("1,删除");
                System.out.println("2,修改");
                System.out.println("3,添加");
                System.out.println("-----------------------------------");
                System.out.print("请选择操作：");
                int choose32 = scanner.nextInt();
                int changeCourseId = -1;
                if (choose32 == 1 || choose32 == 2) {
                    System.out.print("请选择要操作的课程id：");
                    changeCourseId = scanner.nextInt();
                }
                if (choose32 == 1) {
                    Basic.deleteCourse(courseList, changeCourseId);
                } else if (choose32 == 2) {
                    System.out.print("请输入课程名：");
                    String name = scanner.next();
                    System.out.print("请输入老师的手机号：");
                    String teacherPhone = scanner.next();
                    Basic.updateCourse(courseList, changeCourseId, name, teacherPhone);
                } else if (choose32 == 3) {
                    int isContinue = 1;
                    do {
                        System.out.print("请输入课程名：");
                        String name = scanner.next();
                        System.out.print("请输入老师的手机号：");
                        String teacherPhone = scanner.next();
                        Course course = new Course(name, teacherPhone);
                        Basic.addCourse(courseList, course);
                        System.out.print("是否继续添加：（1，是 2，否）");
                        isContinue = scanner.nextInt();
                    } while (isContinue == 1);
                } else {
                    System.out.println("输入错误");
                }
            } else if (choose1 == 4) {
                System.out.println("-----------------------------------");
                System.out.println("编号\t职称名");
                for (Professional p : professionalList) {
                    System.out.println(p);
                }
                System.out.println("-----------------------------------");
                System.out.println("1,删除");
                System.out.println("2,修改");
                System.out.println("3,添加");
                System.out.println("-----------------------------------");
                System.out.print("请选择操作：");
                int choose42 = scanner.nextInt();
                int changeProId = -1;
                if (choose42 == 1 || choose42 == 2) {
                    System.out.print("请选择要操作的职称编号：");
                    changeProId = scanner.nextInt();
                }
                if (choose42 == 1) {
                    Basic.deletePro(professionalList, changeProId);
                } else if (choose42 == 2) {
                    System.out.print("请输入要修改的职称名：");
                    String name = scanner.next();
                    Basic.updatePro(professionalList, changeProId, name);
                } else if (choose42 == 3) {
                    System.out.print("请输入要添加的职称名：");
                    String name = scanner.next();
                    Basic.addPro(professionalList, name);
                } else {
                    System.out.println("输入错误");
                }
            } else if (choose1 == 5) {
                System.out.println("-----------------------------------");
                System.out.println("编号\t职称名");
                for (Professional p : professionalList) {
                    System.out.println(p);
                }
                System.out.println("-----------------------------------");
                System.out.print("请输入要查询的职称名：");
                String proName = scanner.next();
                List<String> list = Basic.getTeacherIdByProId(teacherList, Myuntil.getProIdByName(professionalList, proName));
                System.out.println("姓名\t性别\t年龄\t\t电话\t\t地址\t\t职称");
                for (int i = 0; i < list.size(); i++) {
                    Basic.showTeacher(teacherList, professionalList, list.get(i));
                }
            } else if (choose1 == 6) {
                Basic.showAllCangeCourseAndInfo(changeCourseList, teacherList);
                System.out.println("-----------------------------------");
                System.out.println("1,删除");
                System.out.println("2,修改");
                System.out.println("3,添加");
                System.out.println("4,审核");
                System.out.println("-----------------------------------");
                System.out.print("请选择操作：");
                int choose62 = scanner.nextInt();
                int changeCCId = -1;
                if (choose62 == 1 || choose62 == 2) {
                    System.out.print("请选择要操作的调整课程信息的编号：");
                    changeCCId = scanner.nextInt();
                }
                if (choose62 == 1) {
                    Basic.deleteCC(changeCourseList, changeCCId);
                } else if (choose62 == 2) {
                    System.out.print("请输入要修改的课程名：");
                    String name = scanner.next();
                    System.out.print("请输入要修改的老师手机号：");
                    String cphone = scanner.next();
                    Basic.updateCC(changeCourseList, changeCCId, name, cphone);
                } else if (choose62 == 3) {
                    System.out.print("请输入要添加的课程名：");
                    String name = scanner.next();
                    System.out.println("请输入要添加的老师手机号：");
                    String cphone = scanner.next();
                    Basic.applyCourse(changeCourseList, cphone, name);
                } else if (choose62 == 4) {
                    int isContinue = 1;
                    do{
                        System.out.println("---------------待审批列表---------------");
                        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t地址\t\t课程名\t是否通过\t通过时间");
                        List<String> list = Myuntil.getCCByNotCheekTeacherId(changeCourseList);
                        for (int i = 0; i < list.size();i++){
                            Basic.showAllCangeCourseAndInfo(changeCourseList,teacherList);
                        }
                        System.out.print("请选择要通过审批的编号：");
                        int num = scanner.nextInt();
                        Basic.checkCC(changeCourseList,num);
                        System.out.print("是否继续:(1，是 2，否)");
                        isContinue = scanner.nextInt();
                    }while (isContinue == 1);
                } else {
                    System.out.println("输入错误");
                }
            } else if (choose1 == 7) {
                flag = false;
            } else if (choose1 == 8 && phone.equals("root")) {
                System.out.println("手机号\t\t姓名");
                for (AdminManager a:adminManagerList){
                    if (a.getIsUse() == 0){
                        System.out.println(a);
                    }
                }
                int isContinue = 1;
                do{
                    System.out.print("请选择要启用的账户:");
                    String cphone = scanner.next();
                    Basic.useAdmin(adminManagerList,cphone);
                    System.out.print("是否继续（1,是 2,否）");
                    isContinue = scanner.nextInt();
                }while (isContinue == 1);
            } else {
                System.out.println("输入错误");
            }
        }
    }
}
