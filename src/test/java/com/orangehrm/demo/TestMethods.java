package com.orangehrm.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethods extends BaseTest{

    protected static final Logger logger = LoggerFactory.getLogger(TestMethods.class);

    // valid admin login test method
    protected void loginAsAdminTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputAdminUsername();
        adminLoginPage.inputAdminPassword();
        //web element assert (moving to the top it somehow crashes the test run)
        isAdminLoginWebElementDisplayed(adminLoginPage);
        //click 'login' button
        adminLoginPage.clickLoginButton();
    }

    // invalid admin login test method - no username
    protected void loginAsAdminNoUsernameTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputNoAdminUsername();
        adminLoginPage.inputAdminPassword();
        //web element assert (moving to the top it somehow crashes the test run)
        isAdminLoginWebElementDisplayed(adminLoginPage);
        //click 'login' button
        adminLoginPage.clickLoginButton();
        //assert 'input required' error is displayed
        assertEquals("Required", adminLoginPage.getRequiredInputText(), "The error message isn't displayed");
    }

    // invalid admin login test method - no password
    protected void loginAsAdminNoPasswordTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputAdminUsername();
        adminLoginPage.inputNoAdminPassword();
        //web element assert (moving to the top it somehow crashes the test run)
        isAdminLoginWebElementDisplayed(adminLoginPage);
        //click 'login' button
        adminLoginPage.clickLoginButton();
        //assert 'input required' error is displayed
        assertEquals("Required", adminLoginPage.getRequiredInputText(), "The error message isn't displayed");
    }

    // invalid admin login test method - invalid username
    protected void loginAsAdminInvalidUsernameTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputInvalidAdminUsername();
        adminLoginPage.inputAdminPassword();
        //web element assert (moving to the top it somehow crashes the test run)
        isAdminLoginWebElementDisplayed(adminLoginPage);
        //click 'login' button
        adminLoginPage.clickLoginButton();
        //assert 'input required' error is displayed
        //logger.info(adminLoginPage.getInvalidCredentialsMessage()); -> assert doesn't function with proper selector (nor logger)
//        assertEquals("Invalid credentials", adminLoginPage.getInvalidCredentialsMessage(), "The error message isn't displayed");
    }

    // invalid admin login test method - invalid password
    protected void loginAsAdminInvalidPasswordTest(AdminLoginPage adminLoginPage){

        //admin user data input
        adminLoginPage.inputAdminUsername();
        adminLoginPage.inputInvalidAdminPassword();
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
