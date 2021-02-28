package com.example.ibell;

import com.google.firebase.database.FirebaseDatabase;

public class User {

    private String ID;
    private String Fname;
    private String Lname; //
    private String password;
    private String phoneNumber;
    private Student[] student; //

    public User(){

    }

    public User(String ID, String Fname, String password, String phoneNumber) {
        this.ID = ID;
        this.Fname = Fname;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public static void wsaltButton(){

        FirebaseDatabase.getInstance().getReference("Leaving_student").child(sign_up.student.getS_ID()).setValue(sign_up.student);


    }





}



