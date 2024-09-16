package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashBoardPage extends BasePage{

    //dashboard header title web element
    @FindBy(xpath = "//h6[.='Dashboard']")
    private WebElement dashboardHeader;
    //admin dropdown menu web element
    @FindBy(xpath = "//ul/li[@class='oxd-userdropdown']")
    private WebElement adminDropdownMenu;
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[4]")
    private WebElement adminLogoutLink;


    public AdminDashBoardPage(WebDriver driver) {
        super(driver);
    }

    //admin dropdown menu click method
    public void clickAdminDropdownMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminDropdownMenu));
        adminDropdownMenu.click();
    }
    //admin logout link click method
    public void clickLogoutLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminLogoutLink));
        adminLogoutLink.click();
    }

    //admin dashboard header getter
    public String getDashboardHeaderText(){return dashboardHeader.getText();}

    //admin dashboard web element asserts
    public boolean isAdminDropdownMenuDisplayed(){return adminDropdownMenu.isDisplayed();}

}
