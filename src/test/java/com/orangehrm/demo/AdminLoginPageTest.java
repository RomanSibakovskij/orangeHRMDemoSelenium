package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class AdminLoginPageTest extends TestMethods{
    @Test
    @DisplayName("Login as Administrator test")
    @Tag("Admin_Login")
    void adminLoginTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
    }
}
