package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminDashboardPageTest extends TestMethods{

    //Test 003 -> admin 'change password' test
    @Test
    @DisplayName("Change Password as Administrator Test")
    @Tag("Change_Admin_Password")
    void adminChangePasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        changeAdminPasswordTest(adminChangePasswordPage);
    }

    //Test 003a -> admin login with changed password test (login fails with valid updated password)
    @Test
    @DisplayName("Login with Changed Password as Administrator Test")
    @Tag("Login_New_Admin_Password")
    void adminChangedPasswordLoginTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        changedAdminPasswordLoginTest(adminChangePasswordPage);
    }

    //Test 003b -> invalid admin 'change password' test -> mismatching old password
    @Test
    @DisplayName("Change Password as Administrator Test - Mismatch Old Password")
    @Tag("Invalid_Change_Admin_Password")
    void adminChangeMismatchOldPasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        changeAdminMismatchOldPasswordTest(adminChangePasswordPage);
    }

}
