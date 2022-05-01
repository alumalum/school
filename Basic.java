package com.control;

import com.pojo.*;
import com.untils.Myuntil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basic {
    //管理员登录
    public static boolean Login(List<AdminManager> list, AdminManager admin) {
        if (list == null) {
            return false;
        }
        for (AdminManager a : list) {
            if (a.getPhone().equals(admin.getPhone()) && a.getPassword().equals(admin.getPassword()) && a.getIsUse() == 1) {
                return true;
            }
        }
        return false;
    }

    //老师登录
    public static boolean Login(List<Teacher> list, Teacher teacher) {
        if (list == null) {
            return false;
        }
        for (Teacher t : list) {
            if (t.getPohone().equals(teacher.getPohone()) && t.getPassword().equals(teacher.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //查看个人信息
    public static void showTeacher(List<Teacher> list, List<Professional> professionalList, String phone) {
        Teacher t = Myuntil.getByPhone(list, phone);
        String professional = professionalList.get(t.getProfessionalId()).getName();
        System.out.println(t + "\t\t" + professional);
    }

    //查看自己所有课程信息
    public static void showCourse(List<Course> list, String phone) {
        for (Course course : list) {
            if (course.getTeacherId().equals(phone)) {
                System.out.println(course);
            }
        }
    }

    //查看所有课程信息
    public static void showAllCourse(List<Course> list) {
        for (Course course : list) {
            System.out.println(course);
        }
    }

    //查看所有教师信息及职称
    public static void showAllTeacher(List<Teacher> list, List<Professional> professionalList) {
        System.out.println("姓名\t性别\t年龄\t\t电话\t\t地址\t\t职称");
        for (Teacher t : list) {
            System.out.println(t + "\t\t" + professionalList.get(t.getProfessionalId()).getName());
        }
    }

    //发起课程调整申请
    public static void applyCourse(List<ChangeCourse> changeCourseList, String phone, String name) {
        ChangeCourse changeCourse = new ChangeCourse();
        changeCourse.setCourseName(name);
        changeCourse.setId(Myuntil.getCCId(changeCourseList));
        changeCourse.setTeacherId(phone);
        changeCourse.setCheek('否');
        changeCourseList.add(changeCourse);
        System.out.println("申请成功，等待审批");
    }

    //查看调整申请
    public static void showCangeCourseAndInfo(List<ChangeCourse> changeCourseList, List<Teacher> teacherList, String phone) {
        List<ChangeCourse> list = Myuntil.findById(changeCourseList, phone);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + Myuntil.getByPhone(teacherList, phone).toString() + list.get(i));
        }
    }

    //查看调整申请
    public static void showAllCangeCourseAndInfo(List<ChangeCourse> changeCourseList, List<Teacher> teacherList) {
        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t地址\t\t课程名\t是否通过\t通过时间");
        for (int i = 0; i < changeCourseList.size(); i++) {
            System.out.println(changeCourseList.get(i).getId() + "\t"
                    + Myuntil.getByPhone(teacherList, changeCourseList.get(i).getTeacherId())
                    + "\t\t" + changeCourseList.get(i).toString());
        }
    }

    //删除已经安排的课程
    public static void deleteCourse(List<Course> courseList, int id) {
        Course course = Myuntil.findCourseById(courseList, id);
        courseList.remove(course);
    }

    //修改已经安排的课程
    public static void updateCourse(List<Course> courseList, int id, String name, String phone) {
        Course c = Myuntil.findCourseById(courseList, id);
        c.setName(name);
        c.setTeacherId(phone);
    }

    //安排课程
    public static void addCourse(List<Course> courseList, Course course) {
        course.setId(Myuntil.getCourseId(courseList));
        courseList.add(course);
    }

    //删除职称
    public static void deletePro(List<Professional> professionalList, int id) {
        Professional professional = Myuntil.findProById(professionalList, id);
        professionalList.remove(professional);
    }

    //修改职称
    public static void updatePro(List<Professional> professionalList, int id, String name) {
        Professional professional = Myuntil.findProById(professionalList, id);
        professional.setName(name);
    }

    //添加职称
    public static void addPro(List<Professional> professionalList, String name) {
        Professional professional = new Professional(Myuntil.getProId(professionalList), name);
    }

    //根据职称id查找老师
    public static List<String> getTeacherIdByProId(List<Teacher> teacherList, int id) {
        ArrayList<String> list = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            if (teacher.getProfessionalId() == id) {
                list.add(teacher.getPohone());
            }
        }
        return list;
    }

    //删除课程调整申请
    public static void deleteCC(List<ChangeCourse> changeCourseList, int id) {
        ChangeCourse changeCourse = Myuntil.findCCById(changeCourseList, id);
        changeCourseList.remove(changeCourse);
    }

    //修改课程调整申请
    public static void updateCC(List<ChangeCourse> changeCourseList, int id, String name, String phone) {
        ChangeCourse cc = Myuntil.findCCById(changeCourseList, id);
        cc.setCourseName(name);
        cc.setTeacherId(phone);
    }

    //审批
    public static void checkCC(List<ChangeCourse> changeCourseList, int id) {
        ChangeCourse cc = Myuntil.findCCById(changeCourseList, id);
        cc.setCheek('是');
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cc.setCheekdate(simpleDateFormat.format(new Date()));
    }

    //启用的管理员账户
    public static void useAdmin(List<AdminManager> adminManagerList,String phone){
        AdminManager a = Myuntil.getAdminByPhone(adminManagerList,phone);
        a.setIsUse(1);
    }
}
