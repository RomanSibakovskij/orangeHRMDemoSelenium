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
    @DisplayName("Change Password as Administrator Test")
    @Tag("Change_Admin_Password")
    void adminChangedPasswordLoginTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        AdminChangePasswordPage adminChangePasswordPage = new AdminChangePasswordPage(driver);
        changedAdminPasswordLoginTest(adminChangePasswordPage);
    }

}
