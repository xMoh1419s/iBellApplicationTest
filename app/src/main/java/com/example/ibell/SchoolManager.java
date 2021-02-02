package com.example.ibell;

public class SchoolManager extends User {

    private String employeeID;

    public SchoolManager(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public boolean updateStudent (String ID){
        return false;
    }

    public boolean deleteStudent(String ID){
        return false;
    }

    public boolean createStudent(Student student){
        return false;
    }
}
