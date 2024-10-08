package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminChangePasswordPage extends BasePage{

    //admin change password input field web elements
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement adminNewPasswordInputField;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement adminOldPasswordInputField;
    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement adminConfirmPasswordInputField;
    //cancel button web element
    @FindBy(xpath = "//button[.=' Cancel ']")
    private WebElement cancelButton;
    // submit button web element
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitNewPasswordButton;
    //success message web element
    @FindBy(xpath = "//p[text()='Successfully Saved']")
    private WebElement successPasswordChangeMessage;
    //incorrect current password message web element
    @FindBy(xpath = "//p[text()='Current Password is Incorrect']")
    private WebElement incorrectCurrentPasswordMessage;
    //password don't match message web element
    @FindBy(xpath = "//span[.='Passwords do not match']")
    private WebElement passwordsDoNotMatchMessage;

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
    public void confirmNewPassword() {adminConfirmPasswordInputField.sendKeys(newPassword);}

    //mismatching old password input
    public void enterMismatchingOldPassword() {adminOldPasswordInputField.sendKeys("tacker123");}

    //mismatching new password input
    public void mismatchingConfirmNewPassword() {adminConfirmPasswordInputField.sendKeys("morris445");}

    //click cancel button method
    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(650));
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }

    //click submit new password button method
    public void clickSubmitNewPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(650));
        wait.until(ExpectedConditions.elementToBeClickable(submitNewPasswordButton));
        submitNewPasswordButton.click();
    }

    //new password getter
    public String getNewPassword() {return newPassword;}

    //mismatching confirm password getter
    public String getMismatchingNewPassword() {return adminConfirmPasswordInputField.getAttribute("value");}

    //passwords don't match message getter
    public String getPasswordsDoNotMatchMessage() {return passwordsDoNotMatchMessage.getText();}

    //success password change message getter
    public String getSuccessMessage() {return successPasswordChangeMessage.getText();}

    //incorrect current password message getter
    public String getIncorrectCurrentMessage() {return incorrectCurrentPasswordMessage.getText();}

    //admin change password web element assert methods
    public boolean isAdminOldPasswordInputFieldDisplayed(){return adminOldPasswordInputField.isDisplayed();}
    public boolean isAdminNewPasswordInputFieldDisplayed(){return adminNewPasswordInputField.isDisplayed();}
    public boolean isAdminConfirmPasswordInputFieldDisplayed(){return adminConfirmPasswordInputField.isDisplayed();}
    public boolean isCancelButtonDisplayed(){return cancelButton.isDisplayed();}
    public boolean isSubmitPasswordButtonDisplayed(){return submitNewPasswordButton.isDisplayed();}

}
