package com.example.ibell;

public class Student extends User {

    private String s_name;
    private String s_ID;
    private String schoolName;

    public Student(String s_name, String s_ID, String schoolName) {
        this.s_name = s_name;
        this.s_ID = s_ID;
        this.schoolName = schoolName;
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


}
