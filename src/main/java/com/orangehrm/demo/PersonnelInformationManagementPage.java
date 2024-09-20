package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonnelInformationManagementPage extends BasePage{

    //PIM page input field web elements
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(1) [placeholder]")
    private WebElement employeeNameInputField;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(5) [placeholder]")
    private WebElement supervisorNameInputField;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(2) input")
    private WebElement employeeIDInputField;
    //PIM page dropdown selector web elements
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(6) .oxd-select-wrapper")
    private WebElement jobTitleDropdownSelector;
    //automation tester option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[3]")
    private WebElement atJobOption;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(3) .oxd-select-wrapper")
    private WebElement employmentStatusDropdownSelector;
    //freelance status option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[4]")
    private WebElement fullTimePermanentStatusOption;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(7) .oxd-select-wrapper")
    private WebElement subUnitDropdownSelector;
    //orange HRM option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
    private WebElement orangeHRMOption;
    @FindBy(css = "[class] .oxd-grid-item--gutters:nth-of-type(4) .oxd-select-wrapper")
    private WebElement includeDropdownSelector;
    //freelance status option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
    private WebElement currentAndPastEmployeesOption;
    //reset search button
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetSearchButton;
    //search button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    //input data
    private String employeeName;
    private String supervisorName;
    private int employeeID;

    public PersonnelInformationManagementPage(WebDriver driver) {
        super(driver);
    }

    //PIM user input data getter
    public void inputUserData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        supervisorName = TestDataGenerator.getRandomEmployeeName();
        employeeID = TestDataGenerator.getRandomID();

        System.out.println("Generated data for PIM user search: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("Supervisor name: " + supervisorName);
        logger.info("Employee ID: " + employeeID);
    }

    //employee name input method
    public void inputEmployeeName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField));
        employeeNameInputField.sendKeys(employeeName);
    }
    //supervisor name input method
    public void inputSupervisorName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(supervisorNameInputField));
        supervisorNameInputField.sendKeys(supervisorName);
    }
    //employee ID input method
    public void inputEmployeeID(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(employeeIDInputField));
        employeeIDInputField.sendKeys(String.valueOf(employeeID));
    }
    //job title selector click method
    public void clickJobTitleSelector(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdownSelector));
        jobTitleDropdownSelector.click();
    }
    //automation tester job select method
    public void selectATAsJobTitleOption(){atJobOption.click();}

    //employment status selector click method
    public void clickEmploymentStatusSelector(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(employmentStatusDropdownSelector));
        employmentStatusDropdownSelector.click();
    }
    //automation tester job select method
    public void selectFullTimePermanentStatusOption(){fullTimePermanentStatusOption.click();}

    //subunit selector click method
    public void clickSubUnitSelector(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(subUnitDropdownSelector));
        subUnitDropdownSelector.click();
    }
    //current and past employees job select method
    public void selectOrangeHRMOption(){orangeHRMOption.click();}

    //subunit selector click method
    public void clickIncludeSelector(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(includeDropdownSelector));
        includeDropdownSelector.click();
    }
    //current and past employees job select method
    public void selectCurrentAndPastEmployeesOption(){currentAndPastEmployeesOption.click();}

    //search button click method
    public void clickSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
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

    //selector option getters
    public String getATJobTitleOptionText() {return atJobOption.getText();}
    public String getFullTimePermanentStatusOptionText(){return fullTimePermanentStatusOption.getText();}
    public String getOrangeHRMOptionText(){return orangeHRMOption.getText();}
    public String getCurrentAndPastEmployeesOptionText(){return currentAndPastEmployeesOption.getText();}
}
