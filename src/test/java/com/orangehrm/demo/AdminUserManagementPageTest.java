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

    //Test 004b -> remove specific user from the admin management user table test
    @Test
    @DisplayName("Remove Specific User From User Table")
    @Tag("Remove_Specific_User_From_User_Table")
    void removeSpecificUserFromUserTableTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        removeSelectedUserFromUserTableTest(adminUserManagementPage);
    }

    //Test 004c -> abort removal of a specific user from the admin management user table test
    @Test
    @DisplayName("Abort Removal Of A Specific User From User Table")
    @Tag("Abort_Removal_Specific_User_From_User_Table")
    void abortRemovalOfASpecificUserFromUserTableTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        abortRemoveSelectedUserFromUserTableTest(adminUserManagementPage);
    }

    //Test 004d -> add a new user into the admin management user table test (the new user WASN'T created)
    @Test
    @DisplayName("Add New User Into User Table")
    @Tag("Add_New_User_Into_User_Table")
    void addNewUserIntoTableTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        addNewUserTest();
    }

}
