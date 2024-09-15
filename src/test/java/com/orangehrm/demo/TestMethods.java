package com.orangehrm.demo;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethods extends BaseTest{

    //admin login test method
    protected void loginAsAdminTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputAdminUsername();
        adminLoginPage.inputAdminPassword();
        //web element assert (moving to the top it somehow crashes the test run)
        isAdminLoginWebElementDisplayed(adminLoginPage);
        //click 'login' button
        adminLoginPage.clickLoginButton();
    }

    //admin login page web element assert
    protected void isAdminLoginWebElementDisplayed(AdminLoginPage adminLoginPage){
        //assert username input field is displayed
        assertTrue(adminLoginPage.isUsernameInputFieldDisplayed(), "The username input field is not displayed");
        //assert password input field is displayed
        assertTrue(adminLoginPage.isPasswordInputFieldDisplayed(), "The password input field is not displayed");
        //assert login button is displayed
        assertTrue(adminLoginPage.isLoginButtonDisplayed(), "The login button is not displayed");
    }
}
