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
    //invalid singular input (username length) error message web element
    @FindBy(css = ".oxd-form .oxd-grid-item--gutters:nth-of-type(4) .oxd-input-field-error-message")
    private WebElement invalidUsernameLengthMessage;
    //invalid singular input(password length) error message web element
    @FindBy(css = ".user-password-cell .oxd-input-field-error-message")
    private WebElement invalidPasswordLengthMessage;

    //user input data
    private String employeeName;
    private String username;
    private String password;

    //no singular input data
    private String noEmployeeName;
    private String noUsername;
    private String noPassword;

    //invalid input data
    private String invalidEmployeeName;
    private String tooShortUsername;
    private String tooLongUsername;
    private String tooShortPassword;
    private String tooLongPassword;
    private String invalidPassword;
    private String mismatchingConfirmPassword;

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

    //invalid input methods
    //input user data getter (no singular input)
    public void inputNewUserNoEmployeeNameData(){
        noEmployeeName = "";
        username = TestDataGenerator.generateRandomUsername(6);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("No employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("New password: " + password);
    }
    public void inputNoEmployeeName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField));
        employeeNameInputField.click();
        employeeNameInputField.sendKeys(noEmployeeName);
    }

    //input user data getter (no singular input)
    public void inputNewUserNoUsernameData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        noUsername = "";
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("No username: " + noUsername);
        logger.info("New password: " + password);
    }
    public void inputNoUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(noUsername);
    }

    //input user data getter (no singular input)
    public void inputNewUserNoPasswordData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        username = TestDataGenerator.generateRandomUsername(6);
        noPassword = "";

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("No password: " + noPassword);
    }
    public void inputNoPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(noPassword);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserInvalidEmployeeNameData(){
        invalidEmployeeName = "!@#^^&*$%%";
        username = TestDataGenerator.generateRandomUsername(6);
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Invalid employee name: " + invalidEmployeeName);
        logger.info("New username: " + username);
        logger.info("New password: " + password);
    }
    public void inputInvalidEmployeeName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField));
        employeeNameInputField.click();
        employeeNameInputField.sendKeys(invalidEmployeeName);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserTooShortUsernameData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        tooShortUsername = TestDataGenerator.generateRandomUsername(4); //too short
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("Too short username: " + tooShortUsername);
        logger.info("New password: " + password);
    }
    public void inputTooShortUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(tooShortUsername);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserTooLongUsernameData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        tooLongUsername = TestDataGenerator.generateRandomUsername(41); //too long
        password = TestDataGenerator.generateRandomPassword();

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("Too long username: " + tooLongUsername);
        logger.info("New password: " + password);
    }
    public void inputTooLongUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys(tooLongUsername);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserTooShortPasswordData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        username = TestDataGenerator.generateRandomUsername(6);
        tooShortPassword = "Akg721";

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("Too short password: " + tooShortPassword);
    }
    public void inputTooShortPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(tooShortPassword);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserTooLongPasswordData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        username = TestDataGenerator.generateRandomUsername(6);
        tooLongPassword = "Akg721sdsaddsasdqqwqwqwq123ASSDssafdsfgfdfhgdfQWEsssdssadasdwewe1"; //65 chars

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("Too long password: " + tooLongPassword);
    }
    public void inputTooLongPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(tooLongPassword);
    }

    //input user data getter (invalid singular input)
    public void inputNewUserInvalidPasswordData(){
        employeeName = TestDataGenerator.getRandomEmployeeName();
        username = TestDataGenerator.generateRandomUsername(6);
        invalidPassword = "asdfasdffsdfg";

        System.out.println("Generated data for invalid new user: " + "\n");
        logger.info("Employee name: " + employeeName);
        logger.info("New username: " + username);
        logger.info("Invalid password: " + invalidPassword);
    }
    public void inputInvalidPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(invalidPassword);
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

    //invalid length message test getters
    public String getInvalidUsernameLengthMessage(){return invalidUsernameLengthMessage.getText();}
    public String getInvalidPasswordLengthMessage(){return invalidPasswordLengthMessage.getText();}
}
