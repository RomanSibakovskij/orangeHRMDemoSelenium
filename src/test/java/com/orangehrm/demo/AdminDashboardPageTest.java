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

    //Test 003c -> invalid admin 'change password' test -> mismatching new password
    @Test
    @DisplayName("Change Password as Administrator Test - Mismatch Confirm Password")
    @Tag("Invalid_Change_Admin_Password")
    void adminChangeMismatchNewPasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        changeAdminMismatchNewPasswordTest(adminChangePasswordPage);
    }

    //Test 003d -> admin 'change password' test -> cancel password change
    @Test
    @DisplayName("Cancel Password Change as Administrator Test")
    @Tag("Change_Admin_Password_Cancel")
    void adminCancelChangePasswordTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        cancelChangeAdminPasswordTest(adminChangePasswordPage);
    }

}
