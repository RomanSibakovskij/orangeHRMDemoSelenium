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

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    //admin user data input methods
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

    public void clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    //admin login page web element
    public boolean isUsernameInputFieldDisplayed(){return usernameInputField.isDisplayed();}
    public boolean isPasswordInputFieldDisplayed(){return passwordInputField.isDisplayed();}
    public boolean isLoginButtonDisplayed(){return loginButton.isDisplayed();}
}
