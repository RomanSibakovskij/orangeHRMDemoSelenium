package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminDashboardPageTest extends TestMethods{

    //Test 004 -> click admin aside link test
    @Test
    @DisplayName("Click 'Admin Management Page' Aside Link")
    @Tag("Admin_Aside_Link_Click")
    void adminAsideLinkClickTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
    }

    //Test 006 -> click personnel information management (PIM) aside link test
    @Test
    @DisplayName("Click 'PIM' Aside Link")
    @Tag("PIM_Aside_Link_Click")
    void pimAsideLinkClickTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickPIMPageLinkTest();
    }


}
