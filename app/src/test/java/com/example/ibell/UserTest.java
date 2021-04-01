package com.example.ibell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;





class UserTest {


    User user = new User("1112223334", "صالح", "123456789", "0543216789");

    //Test if the user id start with either 1 or 2 and it is equal to 10 digits or not
    @Test
    void checkID() {
        assertEquals(true, user.checkID(user.getID()));
    }

    //Test if the phone number start with (05) and it is equal to 10 digits or not
    @Test
    void checkPhone() {
        assertEquals(true, user.checkPhoneNumber(user.getPhoneNumber()));
    }

    //Test if the account activation was successful or not
    @Test
    void signupsuccess(){
        assertEquals(user.signupSuccess(), "تم تفعيل الحساب  بنجاح");
    }

}