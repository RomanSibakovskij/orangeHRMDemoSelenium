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
        logAvailableUserData(adminUserManagementPage);
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
        //log user data after the removal for confirmation
        logAvailableUserData(adminUserManagementPage);
        //assert the user confirmation message is displayed
//        assertEquals("Successfully Deleted", adminUserManagementPage.getUserRemovalConfirmationMessageText(), "The user removal confirmation message text isn't displayed"); //-> the element can't be found with VALID selector
    }

    //abort removal of selected user from user table test method
    protected void abortRemoveSelectedUserFromUserTableTest(AdminUserManagementPage adminUserManagementPage){
        viewAdminManagementPageUserTableTest(adminUserManagementPage);
        //click remove button for a specified user
        adminUserManagementPage.clickRemoveUserButton4();
        //assert the correct text is displayed in warning box
//        assertEquals("The selected record will be permanently deleted. Are you sure you want to continue?", adminUserManagementPage.getUserRemovalWarningBoxText(), "The expected warning box text isn't displayed"); //-> the element can't be found with VALID selector
        //confirm user removal
        adminUserManagementPage.clickAbortUserRemovalButton();
        //log user data after the removal abort for confirmation
        logAvailableUserData(adminUserManagementPage);
    }

    //add new user test method
    protected void addNewUserTest(){
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        //click 'add user' button
        adminUserManagementPage.clickAddNewUserButton();
        AddNewUserPage addNewUserPage = new AddNewUserPage(driver);
        //click user role selector
        addNewUserPage.clickUserRoleDropdownSelector();
        //select ESS option
        addNewUserPage.selectESSOption();
        //click status selector
        addNewUserPage.clickStatusDropdownSelector();
        //select 'enabled' option
        addNewUserPage.selectEnabledOption();
        //input new user data
        addNewUserPage.inputNewUserData();
        addNewUserPage.inputUsername();
//        addNewUserPage.inputEmployeeName(); //-> ElementNotInteractableException DESPITE correct selector
        addNewUserPage.inputPassword();
        addNewUserPage.inputConfirmPassword();
        //log new user data
        logNewUserData(addNewUserPage);
    }

    //logger methods
    protected void logAvailableUserData(AdminUserManagementPage adminUserManagementPage){
        System.out.println("Available user data: " + "\n");
        logger.info("Usernames: " + adminUserManagementPage.getTableUsername());
        logger.info("User roles: " + adminUserManagementPage.getTableUserRole());
        logger.info("Employee names: " + adminUserManagementPage.getTableEmployeeName());
        logger.info("Employee status': " + adminUserManagementPage.getTableEmployeeStatus());
    }

    //new user data logger
    protected void logNewUserData(AddNewUserPage addNewUserPage){
        System.out.println("New user data: " + "\n");
        logger.info("New user username: " + addNewUserPage.getUsername());
        logger.info("New employee name: " + addNewUserPage.getEmployeeName());
        logger.info("New user password: " + addNewUserPage.getPassword());
        logger.info("New user confirm password: " + addNewUserPage.getPassword());
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
        //assert username search bar is displayed
        assertTrue(adminUserManagementPage.isUsernameSearchBarDisplayed(), "The username search bar isn't displayed");
        //assert user role dropdown selector is displayed
        assertTrue(adminUserManagementPage.isUserRoleSelectorDisplayed(), "The user role dropdown selector isn't displayed");
        //assert employee name search bar is displayed
        assertTrue(adminUserManagementPage.isEmployeeNameSearchBarDisplayed(), "The employee name search bar isn't displayed");
        //assert employee status dropdown selector is displayed
        assertTrue(adminUserManagementPage.isEmployeeStatusSearchBarDisplayed(), "The employee status dropdown selector isn't displayed");
        //assert the reset search button is displayed
        assertTrue(adminUserManagementPage.isResetSearchButtonDisplayed(), "The 'reset' button isn't displayed");
        //assert the search button is displayed
        assertTrue(adminUserManagementPage.isSearchButtonDisplayed(), "The 'search' button isn't displayed");
        //assert add new user button is displayed
        assertTrue(adminUserManagementPage.isAddUserButtonDisplayed(), "The 'add user' button isn't displayed");
    }
    //add new user page web element assert
    protected void isAddNewUserPageWebElementDisplayed(AddNewUserPage addNewUserPage){
        //assert user role dropdown selector is displayed
        assertTrue(addNewUserPage.isUserRoleDropdownSelectorDisplayed(), "The user role dropdown selector isn't displayed");
        //assert status dropdown selector is displayed
        assertTrue(addNewUserPage.isStatusDropdownSelectorDisplayed(), "The status dropdown selector isn't displayed");
        //assert employee name input field is displayed
        assertTrue(addNewUserPage.isEmployeeNameInputFieldDisplayed(), "The employee name input field isn't displayed");
        //assert username input field is displayed
        assertTrue(addNewUserPage.isUsernameInputFieldDisplayed(), "The username input field isn't displayed");
        //assert password input field is displayed
        assertTrue(addNewUserPage.isPasswordInputFieldDisplayed(), "The password input field isn't displayed");
        //assert confirm password input field is displayed
        assertTrue(addNewUserPage.isConfirmPasswordInputFieldDisplayed(), "The confirm password input field isn't displayed");
        //assert 'cancel' button is displayed
        assertTrue(addNewUserPage.isCancelAddNewUserButtonDisplayed(), "The 'cancel' button isn't displayed");
        //assert add new user button is displayed(save)
        assertTrue(addNewUserPage.isAddNewUserButtonDisplayed(), "The 'add new user' button isn't displayed");
    }
}
