package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminChangePasswordPage extends BasePage{

    //admin change password input field web elements
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement adminNewPasswordInputField;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[1]")
    private WebElement adminOldPasswordInputField;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement adminConfirmPasswordInputField;
    // submit button web element
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitNewPasswordButton;

    //new password input variable
    private String newPassword = TestDataGenerator.generateRandomPassword();

    public AdminChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    //old password input
    public void enterOldPassword() {adminOldPasswordInputField.sendKeys("admin123");}

    //new password input
    public void enterNewPassword() {adminNewPasswordInputField.sendKeys(newPassword);}

    //confirm password input
    public void confirmNewPassword() {adminOldPasswordInputField.sendKeys(newPassword);}

    //click submit new password button method
    public void clickSubmitNewPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(650));
        wait.until(ExpectedConditions.elementToBeClickable(submitNewPasswordButton));
        submitNewPasswordButton.click();
    }

    //new password getter
    public String getNewPassword() {return newPassword;}

    //admin change password web element assert methods
    public boolean isAdminOldPasswordInputFieldDisplayed(){return adminOldPasswordInputField.isDisplayed();}
    public boolean isAdminNewPasswordInputFieldDisplayed(){return adminNewPasswordInputField.isDisplayed();}
    public boolean isAdminConfirmPasswordInputFieldDisplayed(){return adminConfirmPasswordInputField.isDisplayed();}
    public boolean isSubmitPasswordButtonDisplayed(){return submitNewPasswordButton.isDisplayed();}

}
