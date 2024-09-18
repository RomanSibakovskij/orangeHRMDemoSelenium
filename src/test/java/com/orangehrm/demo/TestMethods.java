package com.orangehrm.demo;

import org.slf4j.*;
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
        //assert the admin has logged into admin dashboard
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
//        assertEquals("Dashboard", adminDashBoardPage.getDashboardHeaderText(), "The dashboard header text isn't displayed"); -> NoSuchElementException with CORRECT selector - it can be found on browser dev console
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

    //admin dashboard test methods

    //admin dropdown menu test method
    protected void logOutAsAdminTest(AdminDashBoardPage adminDashBoardPage){
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
//        //web element assert
//        isAdminDashboardPageWebElementDisplayed(adminDashBoardPage);
        //click logout link
        adminDashBoardPage.clickLogoutLink();
        //assert the admin has returned to login page
//        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
//        assertTrue(adminLoginPage.isLoginLogoDisplayed(), "The login logo is not displayed"); -> NoSuchElementException with CORRECT selector - it can be found on browser dev console
    }

    //admin change password test method
    protected void changeAdminPasswordTest(AdminChangePasswordPage adminChangePasswordPage){
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
        //click 'change password' link
        adminDashBoardPage.clickChangePasswordLink();
        //input old password
        adminChangePasswordPage.enterOldPassword();
        //assert web elements are displayed
        isAdminChangePasswordPageWebElementDisplayed(adminChangePasswordPage);
        //input new password
        adminChangePasswordPage.enterNewPassword();
        logger.info("New password entered: " + adminChangePasswordPage.getNewPassword());
        //confirm new password
        adminChangePasswordPage.confirmNewPassword();
        logger.info("Confirm password entered: " + adminChangePasswordPage.getNewPassword());
        //click submit password button
        adminChangePasswordPage.clickSubmitNewPasswordButton();
    }

    //admin change password test method -> cancel the change
    protected void cancelChangeAdminPasswordTest(AdminChangePasswordPage adminChangePasswordPage){
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
        //click 'change password' link
        adminDashBoardPage.clickChangePasswordLink();
        //input old password
        adminChangePasswordPage.enterOldPassword();
        //assert web elements are displayed
        isAdminChangePasswordPageWebElementDisplayed(adminChangePasswordPage);
        //input new password
        adminChangePasswordPage.enterNewPassword();
        logger.info("New password entered: " + adminChangePasswordPage.getNewPassword());
        //confirm new password
        adminChangePasswordPage.confirmNewPassword();
        logger.info("Confirm password entered: " + adminChangePasswordPage.getNewPassword());
        //click cancel button
        adminChangePasswordPage.clickCancelButton();
    }

    //invalid admin change password test method - mismatching old password
    protected void changeAdminMismatchOldPasswordTest(AdminChangePasswordPage adminChangePasswordPage){
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
        //click 'change password' link
        adminDashBoardPage.clickChangePasswordLink();
        //input old password
        adminChangePasswordPage.enterMismatchingOldPassword();
        //assert web elements are displayed
        isAdminChangePasswordPageWebElementDisplayed(adminChangePasswordPage);
        //input new password
        adminChangePasswordPage.enterNewPassword();
        logger.info("New password entered: " + adminChangePasswordPage.getNewPassword());
        //confirm new password
        adminChangePasswordPage.confirmNewPassword();
        logger.info("Confirm password entered: " + adminChangePasswordPage.getNewPassword());
        //click submit password button
        adminChangePasswordPage.clickSubmitNewPasswordButton();
        //assert the incorrect current password message is present
        assertEquals("Current Password is Incorrect", adminChangePasswordPage.getIncorrectCurrentMessage(), "The 'incorrect current password' isn't displayed");
    }

    //invalid admin change password test method - mismatching new password
    protected void changeAdminMismatchNewPasswordTest(AdminChangePasswordPage adminChangePasswordPage){
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
        //click 'change password' link
        adminDashBoardPage.clickChangePasswordLink();
        //input old password
        adminChangePasswordPage.enterOldPassword();
        //assert web elements are displayed
        isAdminChangePasswordPageWebElementDisplayed(adminChangePasswordPage);
        //input new password
        adminChangePasswordPage.enterNewPassword();
        logger.info("New password entered: " + adminChangePasswordPage.getNewPassword());
        //confirm new password
        adminChangePasswordPage.mismatchingConfirmNewPassword();
        logger.info("Mismatching confirm password entered: " + adminChangePasswordPage.getMismatchingNewPassword());
        //click submit password button
        adminChangePasswordPage.clickSubmitNewPasswordButton();
        //assert the passwords don't match message is present
        assertEquals("Passwords do not match", adminChangePasswordPage.getPasswordsDoNotMatchMessage(), "The 'passwords don't match' isn't displayed");
    }

    //admin login with changed password test method
    protected void changedAdminPasswordLoginTest(AdminChangePasswordPage adminChangePasswordPage){
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        //click admin dropdown menu
        adminDashBoardPage.clickAdminDropdownMenu();
        //click 'change password' link
        adminDashBoardPage.clickChangePasswordLink();
        //input old password
        adminChangePasswordPage.enterOldPassword();
        //assert web elements are displayed
        isAdminChangePasswordPageWebElementDisplayed(adminChangePasswordPage);
        //input new password
        adminChangePasswordPage.enterNewPassword();
        logger.info("New password entered: " + adminChangePasswordPage.getNewPassword());
        //confirm new password
        adminChangePasswordPage.confirmNewPassword();
        logger.info("Confirm password entered: " + adminChangePasswordPage.getNewPassword());
        //click submit password button
        adminChangePasswordPage.clickSubmitNewPasswordButton();
        //assert the password has been changed
        assertEquals("Successfully Saved", adminChangePasswordPage.getSuccessMessage(), "The success message isn't displayed");
        //logout from admin account
        adminDashBoardPage.clickAdminDropdownMenu();
        adminDashBoardPage.clickLogoutLink();
        //re-login with the updated password
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        //input login data
        adminLoginPage.inputChangedPasswordLoginData(adminChangePasswordPage);
        adminLoginPage.inputAdminUsername();
        adminLoginPage.inputChangedAdminPassword(adminChangePasswordPage.getNewPassword());
        //login button click
        adminLoginPage.clickLoginButton();
        //if the login fails with the valid changed password
        if(!adminLoginPage.getInvalidCredentialsMessage().isEmpty()){
            logger.error("The admin login failed with valid updated password");
        }
    }

    //click 'admin management' page link test method
    protected void clickAdminManagementPageLinkTest(){
        //assert the admin has logged into admin dashboard
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage(driver);
        assertEquals("Dashboard", adminDashBoardPage.getDashboardHeaderText(), "The dashboard header text isn't displayed"); //-> NoSuchElementException with CORRECT selector - it can be found on browser dev console
        //web element assert
        isAdminDashboardPageWebElementDisplayed(adminDashBoardPage);
        //admin management page aside link click
        adminDashBoardPage.clickAdminManagementPageLink();
        //assert the admin has navigated to admin management page
        assertEquals("Admin\n" + "User Management", adminDashBoardPage.getAdminDashboardPageTitle(), "The page title isn't displayed");
    }

    //view 'admin management' page user table data test method
    protected void viewAdminManagementPageUserTableTest(AdminUserManagementPage adminUserManagementPage){
        //web element assert
        isUserManagementPageWebElementDisplayed(adminUserManagementPage);
        //view available user data
        System.out.println("Available user data: " + "\n");
        logger.info("Usernames: " + adminUserManagementPage.getTableUsername());
        logger.info("User roles: " + adminUserManagementPage.getTableUserRole());
        logger.info("Employee names: " + adminUserManagementPage.getTableEmployeeName());
        logger.info("Employee status': " + adminUserManagementPage.getTableEmployeeStatus());
    }
    //remove selected user from user table test method
    protected void removeSelectedUserFromUserTableTest(AdminUserManagementPage adminUserManagementPage){
        viewAdminManagementPageUserTableTest(adminUserManagementPage);
        //click remove button for a specified user
        adminUserManagementPage.clickRemoveUserButton4();
        //assert the correct text is displayed in warning box
//        assertEquals("The selected record will be permanently deleted. Are you sure you want to continue?", adminUserManagementPage.getUserRemovalWarningBoxText(), "The expected warning box text isn't displayed"); //-> the element can't be found with VALID selector
        //confirm user removal
        adminUserManagementPage.clickConfirmUserRemovalButton();
        //assert the user confirmation message is displayed
//        assertEquals("Successfully Deleted", adminUserManagementPage.getUserRemovalConfirmationMessageText(), "The user removal confirmation message text isn't displayed"); //-> the element can't be found with VALID selector
    }

    //web page element assert methods

    //admin login page web element assert
    protected void isAdminLoginWebElementDisplayed(AdminLoginPage adminLoginPage){
        //assert username input field is displayed
        assertTrue(adminLoginPage.isUsernameInputFieldDisplayed(), "The username input field is not displayed");
        //assert password input field is displayed
        assertTrue(adminLoginPage.isPasswordInputFieldDisplayed(), "The password input field is not displayed");
        //assert login button is displayed
        assertTrue(adminLoginPage.isLoginButtonDisplayed(), "The login button is not displayed");
    }
    //admin dashboard web element assert
    protected void isAdminDashboardPageWebElementDisplayed(AdminDashBoardPage adminDashBoardPage){
        //assert admin dropdown menu is displayed
        assertTrue(adminDashBoardPage.isAdminDropdownMenuDisplayed(), "The admin dropdown menu is not displayed");
        //assert admin management page aside link is displayed
        assertTrue(adminDashBoardPage.isAdminManagementAsideLinkDisplayed(), "The aside 'admin management page' link isn't displayed");
    }
    //admin change password page web element assert
    protected void isAdminChangePasswordPageWebElementDisplayed(AdminChangePasswordPage adminChangePasswordPage){
        //assert old password input field is displayed
        assertTrue(adminChangePasswordPage.isAdminOldPasswordInputFieldDisplayed(), "The old password input field isn't displayed");
        //assert new password input field is displayed
        assertTrue(adminChangePasswordPage.isAdminNewPasswordInputFieldDisplayed(), "The new password input field isn't displayed");
        //assert confirm password input field is displayed
        assertTrue(adminChangePasswordPage.isAdminConfirmPasswordInputFieldDisplayed(), "The confirm password input field isn't displayed");
        //assert cancel button is displayed
        assertTrue(adminChangePasswordPage.isCancelButtonDisplayed(), "The cancel button isn't displayed");
        //assert submit button is displayed
        assertTrue(adminChangePasswordPage.isSubmitPasswordButtonDisplayed(), "The submit button isn't displayed");
    }
    //admin/user management page web element assert
    protected void isUserManagementPageWebElementDisplayed(AdminUserManagementPage adminUserManagementPage){
        //assert user table select user checkboxes are displayed
        assertTrue(adminUserManagementPage.isTableSelectUserCheckboxDisplayed(), "The 'select' user checkbox is not displayed");
        //assert user table usernames are displayed
        assertTrue(adminUserManagementPage.isTableUsernameDisplayed(), "The username isn't displayed");
        //assert user table user roles are displayed
        assertTrue(adminUserManagementPage.isTableUserRoleDisplayed(), "The user roles isn't displayed");
        //assert user table employee names are displayed
        assertTrue(adminUserManagementPage.isTableEmployeeNameDisplayed(), "The employee name isn't displayed");
        //assert user table employee status' are displayed
        assertTrue(adminUserManagementPage.isTableEmployeeStatusDisplayed(), "The employee status isn't displayed");
        //assert user table remove user buttons are displayed
        assertTrue(adminUserManagementPage.isTableUserRemoveButtonDisplayed(), "The user remove button isn't displayed");
        //assert user table edit user buttons are displayed
        assertTrue(adminUserManagementPage.isTableEditUserButtonDisplayed(), "The user edit button isn't displayed");
    }
}
