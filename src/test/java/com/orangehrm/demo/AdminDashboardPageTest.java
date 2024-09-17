package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminDashboardPageTest extends TestMethods{

    //Test 004 -> click admin aside link test
    @Test
    @DisplayName("Click 'Admin Management Page' Aside Link")
    @Tag("Valid_Admin_Login")
    void adminAsideLinkClickTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
    }

}
