package com.example.ibell;

public class Student extends User {

    private String s_name;
    private String s_ID;
    private String schoolName;
    private String g_name;
    private String l_name;
    private String f_name;
    private String f_ID;

    public Student(String s_name, String f_name, String g_name, String l_name, String s_ID, String f_ID, String schoolName) {

        this.s_name = s_name;
        this.s_ID = s_ID;
        this.schoolName = schoolName;
        this.g_name = g_name;
        this.l_name = l_name;
        this.f_name = f_name;
        this.f_ID = f_ID;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_ID() {
        return s_ID;
    }

    public void setS_ID(String s_ID) {
        this.s_ID = s_ID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_ID() {
        return f_ID;
    }

    public void setF_ID(String f_ID) {
        this.f_ID = f_ID;
    }

    public String getFullName() {
        return s_name + " " + f_name + " " + g_name + " " + l_name;
    }
}
