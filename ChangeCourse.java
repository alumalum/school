package com.pojo;

import java.io.Serializable;

public class ChangeCourse implements Serializable {
    private int id;//主键
    private String courseName;//课程名
    private char cheek;//是否通过审核
    private String cheekdate;//审核时间
    private String teacherId;//老师id

    public ChangeCourse() {
    }

    public ChangeCourse(int id, String courseName, char cheek, String cheekdate,String teacherId) {
        this.id = id;
        this.courseName = courseName;
        this.cheek = cheek;
        this.cheekdate = cheekdate;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCheek() {
        return cheek;
    }

    public void setCheek(char cheek) {
        this.cheek = cheek;
    }

    public String getCheekdate() {
        return cheekdate;
    }

    public void setCheekdate(String cheekdate) {
        this.cheekdate = cheekdate;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "\t" + courseName + "\t" + cheek + "\t" + cheekdate;
    }
}
