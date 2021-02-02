package com.example.ibell;

public class User {

    private String ID;
    private String Fname;
    private String Lname;
    private String password;
    private Number phoneNumber;
    private Student[] student;

    public User(){

    }

    public User(String ID, String Fname, String Lname, String password, Number phoneNumber) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }

    public boolean Login(String id, String pass){
        return false;

    }

    public void wsaltButton(){

    }




}



