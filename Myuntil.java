package com.untils;

import com.pojo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Myuntil<E> {
    //获取id
    public static int getCCId(List<ChangeCourse> list) {
        if (list.size() == 0) {
            return 0;
        }
        return (list.get(list.size() - 1).getId() + 1);
    }

    public static int getCourseId(List<Course> list) {
        if (list.size() == 0) {
            return 0;
        }
        return (list.get(list.size() - 1).getId() + 1);
    }

    public static int getProId(List<Professional> list) {
        if (list.size() == 0) {
            return 0;
        }
        return (list.get(list.size() - 1).getId() + 1);
    }

    //根据id查找
    public static List<ChangeCourse> findById(List<ChangeCourse> list, String phone) {
        List<ChangeCourse> resList = new ArrayList<>();
        for (ChangeCourse changeCourse : list) {
            if (changeCourse.getTeacherId().equals(phone)) {
                resList.add(changeCourse);
            }
        }
        return resList;
    }

    public static ChangeCourse findCCById(List<ChangeCourse> list, int id) {
        ChangeCourse changeCourse = null;
        for (ChangeCourse c : list) {
            if (c.getId() == id) {
                changeCourse = c;
            }
        }
        return changeCourse;
    }

    public static Course findCourseById(List<Course> courseList, int id) {
        Course course = null;
        for (Course c : courseList) {
            if (c.getId() == id) {
                course = c;
            }
        }
        return course;
    }

    public static Professional findProById(List<Professional> professionalList, int id) {
        Professional professional = null;
        for (Professional p : professionalList) {
            if (p.getId() == id) {
                professional = p;
            }
        }
        return professional;
    }

    //根据手机号查找
    public static Teacher getByPhone(List<Teacher> teacherList, String phone) {
        Teacher teacher = null;
        for (Teacher t : teacherList) {
            if (t.getPohone().equals(phone)) {
                teacher = t;
            }
        }
        return teacher;
    }

    //根据手机号查找
    public static AdminManager getAdminByPhone(List<AdminManager> list, String phone) {
        AdminManager adminManager = null;
        for (AdminManager a : list) {
            if (a.getPhone().equals(phone)) {
                adminManager = a;
            }
        }
        return adminManager;
    }

    //根据职称名查找id
    public static int getProIdByName(List<Professional> professionalList, String name) {
        int id = -1;
        for (Professional p : professionalList) {
            if (p.getName().equals(name)) {
                id = p.getId();
            }
        }
        return id;
    }

    //查看所有未通过审核的老师
    public static List<String> getCCByNotCheekTeacherId(List<ChangeCourse> changeCourseList) {
        List<String> list = new ArrayList<>();
        for (ChangeCourse c : changeCourseList) {
            if (c.getCheek() == '否') {
                list.add(c.getTeacherId());
            }
        }
        return list;
    }

    //读序列化文件
    public <E> ArrayList<E> readFile(String path) {
        ArrayList<E> arrayList = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            arrayList = (ArrayList<E>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    //写序列化文件
    public <E> void writeFile(String path, ArrayList<E> list) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //文件初始化
    public void init(String path) {
        File fileAdmin = new File(path + "adminList.txt");
        File fileProfessional = new File(path + "professionalList.txt");
        if (!fileAdmin.exists()) {
            ArrayList<AdminManager> list = new ArrayList<>();
            list.add(new AdminManager("root", "root", "root", 1));
            writeFile(path + "adminList.txt", list);
        }
        if (!fileProfessional.exists()) {
            ArrayList<Professional> professionalArrayList = new ArrayList<>();
            professionalArrayList.add(new Professional(0, "教授"));
            professionalArrayList.add(new Professional(1, "副教授"));
            professionalArrayList.add(new Professional(2, "讲师"));
            professionalArrayList.add(new Professional(3, "高级教师"));
            writeFile(path + "professionalList.txt", professionalArrayList);
        }
    }
}
