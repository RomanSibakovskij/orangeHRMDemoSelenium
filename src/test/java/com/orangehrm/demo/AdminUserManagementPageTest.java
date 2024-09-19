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

    //Test 005 -> search for admins with enabled status test
    @Test
    @DisplayName("Search For Admins with Enabled Status")
    @Tag("Search_For_Admins")
    void searchForEnabledAdminsTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        searchForEnabledAdminsTest(adminUserManagementPage);
    }

    //Test 005a -> search for ESS users with disabled status test
    @Test
    @DisplayName("Search For Admins with Enabled Status")
    @Tag("Search_For_Admins")
    void searchForDisabledESSUsersTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        searchForDisabledESSUsersTest(adminUserManagementPage);
    }

    //Test 005b -> cancel the search for admins with enabled status test
    @Test
    @DisplayName("Cancel The Search For Admins with Enabled Status")
    @Tag("Cancel_Search_For_Admins")
    void cancelSearchForEnabledAdminsTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickAdminManagementPageLinkTest();
        AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);
        cancelSearchForEnabledAdminsTest(adminUserManagementPage);
    }

}
