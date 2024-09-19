package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminUserManagementNewUserPageTest extends TestMethods{

    //Test 004d -> add a new user into the admin management user table test (the new user WASN'T created)
    @Test
    @DisplayName("Add New User Into User Table")
    @Tag("Add_New_User_Into_User_Table")
    void addNewUserIntoTableTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        addNewUserTest();
    }

    //Test 004e -> add a new user into the admin management user table test (no employee name)
    @Test
    @DisplayName("Add New User Into User Table - No Employee Name")
    @Tag("Invalid_Add_New_User_Into_User_Table")
    @Tag("No_Singular_Input")
    void addNewUserIntoTableNoEmployeeNameTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        addNewUserNoEmployeeNameTest();
    }

    //Test 004f -> add a new user into the admin management user table test (no username)
    @Test
    @DisplayName("Add New User Into User Table - No Username")
    @Tag("Invalid_Add_New_User_Into_User_Table")
    @Tag("No_Singular_Input")
    void addNewUserIntoTableNoUsernameTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        addNewUserNoUsernameTest();
    }

    //Test 004g -> add a new user into the admin management user table test (no password)
    @Test
    @DisplayName("Add New User Into User Table - No Password")
    @Tag("Invalid_Add_New_User_Into_User_Table")
    @Tag("No_Singular_Input")
    void addNewUserIntoTableNoPasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        addNewUserNoPasswordTest();
    }

}
