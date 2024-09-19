package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewUserPage extends BasePage{

    //add new user web page elements
    @FindBy(css = ".oxd-form .oxd-grid-item--gutters:nth-of-type(1) .oxd-select-wrapper")
    private WebElement userRoleDropdownSelector;
    //ESS option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[3]")
    private WebElement essOption;
    @FindBy(css = ".oxd-form .oxd-grid-item--gutters:nth-of-type(3) .oxd-select-wrapper")
    private WebElement statusDropdownSelector;
    //enabled status option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
    private WebElement enabledStatusOption;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInputField;
    @FindBy(css = ".oxd-form .oxd-form-row:nth-of-type(1) [autocomplete]")
    private WebElement usernameInputField;
    @FindBy(css = ".user-password-cell [type]")
    private WebElement passwordInputField;
    @FindBy(css = ".oxd-grid-item--gutters:nth-of-type(2) [type]")
    private WebElement confirmPasswordInputField;
    //add new user page button web elements
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement cancelAddNewUserButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addNewUserButton;

    //user input data
    private String employeeName;
    private String username;
    private String password;


    public AddNewUserPage(WebDriver driver) {
        super(driver);
    }

    //user selector click methods
    public void clickUserRoleDropdownSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdownSelector));
        userRoleDropdownSelector.click();
    }
    public void selectESSOption() {essOption.click();}
    public void clickStatusDropdownSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdownSelector));
        statusDropdownSelector.click();
    }
    public void selectEnabledOption() {enabledStatusOption.click();}

    //input user data getter
    public void inputNewUserData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        username = TestDataGenerator.generateRandomUsername(6); //min 5 chars
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("New password: " + password);
    }

    public void inputEmployeeName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField));
        employeeNameInputField.click();
        employeeNameInputField.sendKeys(employeeName);
    }
    public void inputUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(username);
    }
    public void inputPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(password);
    }
    public void inputConfirmPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInputField));
        confirmPasswordInputField.sendKeys(password);
    }

    //add new user click button methods
    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(cancelAddNewUserButton));
        cancelAddNewUserButton.click();
    }
    public void clickAddNewUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(cancelAddNewUserButton));
        cancelAddNewUserButton.click();
    }

    //add new user page web element assert methods
    public boolean isUserRoleDropdownSelectorDisplayed() {return userRoleDropdownSelector.isDisplayed();}
    public boolean isStatusDropdownSelectorDisplayed() {return statusDropdownSelector.isDisplayed();}
    public boolean isEmployeeNameInputFieldDisplayed() {return employeeNameInputField.isDisplayed();}
    public boolean isUsernameInputFieldDisplayed() {return usernameInputField.isDisplayed();}
    public boolean isPasswordInputFieldDisplayed() {return passwordInputField.isDisplayed();}
    public boolean isConfirmPasswordInputFieldDisplayed() {return confirmPasswordInputField.isDisplayed();}
    public boolean isCancelAddNewUserButtonDisplayed() {return cancelAddNewUserButton.isDisplayed();}
    public boolean isAddNewUserButtonDisplayed() {return addNewUserButton.isDisplayed();}

    //new user data getters
    public String getEmployeeName(){return employeeName;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
}
