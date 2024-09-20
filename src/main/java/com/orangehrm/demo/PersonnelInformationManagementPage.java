package com.orangehrm.demo;

import org.openqa.selenium.*;

public class PersonnelInformationManagementPage extends BasePage{

    //PIM page input field web elements
    private WebElement employeeNameInputField;
    private WebElement supervisorNameInputField;
    private WebElement employeeIDInputField;
    //PIM page dropdown selector web elements
    private WebElement jobTitleDropdownSelector;
    private WebElement employmentStatusDropdownSelector;
    private WebElement subUnitDropdownSelector;
    private WebElement includeDropdownSelector;
    //reset search button
    private WebElement resetSearchButton;
    //search button
    private WebElement searchButton;

    public PersonnelInformationManagementPage(WebDriver driver) {
        super(driver);
    }


    //PIM page web assert methods
    public boolean isEmployeeNameInputFieldDisplayed() {return employeeNameInputField.isDisplayed();}
    public boolean isSupervisorNameInputFieldDisplayed() {return supervisorNameInputField.isDisplayed();}
    public boolean isEmployeeIDInputFieldDisplayed() {return employeeIDInputField.isDisplayed();}
    public boolean isJobTitleDropdownSelectorDisplayed() {return jobTitleDropdownSelector.isDisplayed();}
    public boolean isEmploymentStatusDropdownSelectorDisplayed() {return employmentStatusDropdownSelector.isDisplayed();}
    public boolean isSubUnitDropdownSelectorDisplayed() {return subUnitDropdownSelector.isDisplayed();}
    public boolean isIncludeDropdownSelectorDisplayed() {return includeDropdownSelector.isDisplayed();}
    public boolean isResetSearchButtonDisplayed() {return resetSearchButton.isDisplayed();}
    public boolean isSearchButtonDisplayed() {return searchButton.isDisplayed();}
}
