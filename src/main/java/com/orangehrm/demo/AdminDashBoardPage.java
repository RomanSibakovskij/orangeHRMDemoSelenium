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
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[3]")
    private WebElement adminChangePasswordLink;
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[4]")
    private WebElement adminLogoutLink;

    //admin dashboard aside links web elements
    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[1]")
    private WebElement adminManagementPageAsideLink;
    //admin dashboard page title element
    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
    private WebElement adminDashboardPageTitle;

    public AdminDashBoardPage(WebDriver driver) {
        super(driver);
    }

    //admin dropdown menu click method
    public void clickAdminDropdownMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminDropdownMenu));
        adminDropdownMenu.click();
    }
    //admin change password link click
    public void clickChangePasswordLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminChangePasswordLink));
        adminChangePasswordLink.click();
    }
    //admin logout link click method
    public void clickLogoutLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminLogoutLink));
        adminLogoutLink.click();
    }

    //admin management page link click method
    public void clickAdminManagementPageLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(adminManagementPageAsideLink));
        adminManagementPageAsideLink.click();
    }

    //admin dashboard header getter
    public String getDashboardHeaderText(){return dashboardHeader.getText();}

    //get admin dashboard page title
    public String getAdminDashboardPageTitle(){return adminDashboardPageTitle.getText();}

    //admin dashboard web element asserts
    public boolean isAdminDropdownMenuDisplayed(){return adminDropdownMenu.isDisplayed();}
    public boolean isAdminManagementAsideLinkDisplayed(){return adminManagementPageAsideLink.isDisplayed();}

}
