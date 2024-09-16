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
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        changeAdminPasswordTest();
    }
    
}
