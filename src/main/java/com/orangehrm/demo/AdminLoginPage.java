package com.orangehrm.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminLoginPage extends BasePage{

    //login input field web elements
    @FindBy(xpath = "//form[@class='oxd-form']/div[1]/div[1]/div[2]/input")
    private WebElement usernameInputField;
    @FindBy(xpath = "//form[@class='oxd-form']/div[2]/div[1]/div[2]/input")
    private WebElement passwordInputField;
    //login button web element
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    //invalid credentials alert text web element
    @FindBy(css= ".oxd-alert--error")
    private WebElement invalidCredentialsMessage;
    //input fields error text web elements
    @FindBy(xpath = "//span[.='Required']")
    private WebElement inputRequiredText;

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    // valid admin user data input methods
    public void inputAdminUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys("Admin");
    }

    public void inputAdminPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys("admin123");
    }

    //invalid admin user data input - no singular input
    public void inputNoAdminUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys("");
    }

    public void inputNoAdminPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys("");
    }

    //invalid admin user data input - invalid singular input
    public void inputInvalidAdminUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.sendKeys("toker");
    }

    public void inputInvalidAdminPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys("admin");
    }

    //submit button click method
    public void clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    //admin login page web element
    public boolean isUsernameInputFieldDisplayed(){return usernameInputField.isDisplayed();}
    public boolean isPasswordInputFieldDisplayed(){return passwordInputField.isDisplayed();}
    public boolean isLoginButtonDisplayed(){return loginButton.isDisplayed();}

    //invalid message getters
    public String getRequiredInputText(){return inputRequiredText.getText();}
    public String getInvalidCredentialsMessage(){return invalidCredentialsMessage.getText();}
}
