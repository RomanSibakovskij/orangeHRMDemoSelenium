package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminLoginPageTest extends TestMethods{

    //Test 001 -> valid admin user login test
    @Test
    @DisplayName("Login as Administrator Test")
    @Tag("Valid_Admin_Login")
    void adminLoginTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
    }

    //Test 001a -> invalid admin user login test - no username
    @Test
    @DisplayName("Login as Administrator Test - No Username")
    @Tag("Invalid_Admin_Login")
    void adminLoginNoUsernameTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminNoUsernameTest(adminLoginPage);
    }

    //Test 001b -> invalid admin user login test - no password
    @Test
    @DisplayName("Login as Administrator Test - No Password")
    @Tag("Invalid_Admin_Login")
    void adminLoginNoPasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminNoPasswordTest(adminLoginPage);
    }

    //Test 001c -> invalid admin user login test - invalid username
    @Test
    @DisplayName("Login as Administrator Test - Invalid Username")
    @Tag("Invalid_Admin_Login")
    void adminLoginInvalidUsernameTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminInvalidUsernameTest(adminLoginPage);
    }

    //Test 001d -> invalid admin user login test - invalid password
    @Test
    @DisplayName("Login as Administrator Test - Invalid Password")
    @Tag("Invalid_Admin_Login")
    void adminLoginInvalidPasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminInvalidPasswordTest(adminLoginPage);
    }
}
