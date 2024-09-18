package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminUserManagementPageTest extends TestMethods{

    //Test 004a -> view admin management table user data test
    @Test
    @DisplayName("View Available User Data")
    @Tag("Admin_Management_Page_View_User_Data")
    void viewUserTableDataTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        viewAdminManagementPageUserTableTest(adminUserManagementPage);
    }

}
