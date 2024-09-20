package com.orangehrm.demo;

import org.junit.jupiter.api.*;

public class PersonnelInformationManagementPageTest extends TestMethods{

    //Test 007 -> search for a specific user in personnel information management (PIM) page test
    @Test
    @DisplayName("Search For A Specific User in PIM Page")
    @Tag("Specific_User_Search")
    void searchForAUserInPIMPageTest(){
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        loginAsAdminTest(adminLoginPage);
        clickPIMPageLinkTest();
        PersonnelInformationManagementPage personnelInformationManagementPage = new PersonnelInformationManagementPage(driver);
        searchForASpecificUserWithInputTest(personnelInformationManagementPage);
    }

}
