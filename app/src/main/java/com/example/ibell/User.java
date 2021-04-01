package com.example.ibell;

import com.google.firebase.database.FirebaseDatabase;

public class User {

    private String ID;
    private String Fname;
    private String password;
    private String phoneNumber;


    public User(){

    }

    public User(String ID, String Fname, String password, String phoneNumber) {
        this.ID = ID;
        this.Fname = Fname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public User(String ID) {
        this.ID = ID;
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

    public static void wsaltButton(){
        FirebaseDatabase.getInstance().getReference("Leaving_student").child(sign_up.student.getS_ID()).setValue(sign_up.student);
    }
    public static String phoneNum(){
        return sign_up.user.getPhoneNumber();
    }

    public boolean checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length() == 10 || phoneNumber.startsWith("05")){
            return true;
        }
        return false;
    }
    public boolean checkID(String id){
        if(id.matches("(1|2).*") || id.length() == 10){
            return true;
        }
        return false;
    }
    public String signupSuccess(){
        return "تم تفعيل الحساب  بنجاح";
    }






}



