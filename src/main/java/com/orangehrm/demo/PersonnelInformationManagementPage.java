package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PersonnelInformationManagementPage extends BasePage{

    //PIM page input field web elements
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(1) [placeholder]")
    private WebElement employeeNameInputField;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(5) [placeholder]")
    private WebElement supervisorNameInputField;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(2) input")
    private WebElement employeeIDInputField;
    //PIM page dropdown selector web elements
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[2]")
    private WebElement jobTitleDropdownSelector;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(3) .oxd-select-wrapper")
    private WebElement employmentStatusDropdownSelector;
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[3]")
    private WebElement subUnitDropdownSelector;
    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
    private WebElement includeDropdownSelector;
    //reset search button
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetSearchButton;
    //search button
    @FindBy(xpath = "//button[@type='submit']")
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
