package com.orangehrm.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class AdminUserManagementPage extends BasePage{

    //user table web elements (lists)
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[1]")
    private List<WebElement> userTableSelectUserCheckboxes;
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[2]")
    private List<WebElement> userTableUsernameElements;
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[3]")
    private List<WebElement> userTableUserRoleElements;
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[4]")
    private List<WebElement> userTableEmployeeNameElements;
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[5]")
    private List<WebElement> userTableEmployeeStatusElements;
    //user table button elements (lists)
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[6]/div[1]/button[1]")
    private List<WebElement> userTableRemoveUserButtons;
    @FindBy(xpath = "//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@role='row']/div[6]/div[1]/button[2]")
    private List<WebElement> userTableEditUserButtons;

    public AdminUserManagementPage(WebDriver driver) {
        super(driver);
    }

    //user select checkboxes click methods
    public void selectUserCheckbox(int productIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(userTableSelectUserCheckboxes.get(productIndex)));
        userTableSelectUserCheckboxes.get(productIndex).click();
    }
    public void selectUserCheckbox1() {selectUserCheckbox(0);}
    public void selectUserCheckbox2() {selectUserCheckbox(1);}
    public void selectUserCheckbox3() {selectUserCheckbox(2);}
    public void selectUserCheckbox4() {selectUserCheckbox(3);}
    public void selectUserCheckbox5() {selectUserCheckbox(4);}
    public void selectUserCheckbox6() {selectUserCheckbox(5);}

    //user table data view methods
    public List<String> getTableUsername() {
        List<String> userName = new ArrayList<>();
        for (WebElement element : userTableUsernameElements) {
            userName.add(element.getText());
        }
        return userName;
    }

    public List<String> getTableUserRole() {
        List<String> userRole = new ArrayList<>();
        for (WebElement element : userTableUserRoleElements) {
            userRole.add(element.getText());
        }
        return userRole;
    }

    public List<String> getTableEmployeeName() {
        List<String> employeeName = new ArrayList<>();
        for (WebElement element : userTableEmployeeNameElements) {
            employeeName.add(element.getText());
        }
        return employeeName;
    }

    public List<String> getTableEmployeeStatus() {
        List<String> employeeStatus = new ArrayList<>();
        for (WebElement element : userTableEmployeeStatusElements) {
            employeeStatus.add(element.getText());
        }
        return employeeStatus;
    }

    //user remove/edit buttons click methods
    public void clickRemoveUserButton(int productIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(userTableRemoveUserButtons.get(productIndex)));
        userTableRemoveUserButtons.get(productIndex).click();
    }
    public void clickRemoveUserButton1() {clickRemoveUserButton(0);}
    public void clickRemoveUserButton2() {clickRemoveUserButton(1);}
    public void clickRemoveUserButton3() {clickRemoveUserButton(2);}
    public void clickRemoveUserButton4() {clickRemoveUserButton(3);}
    public void clickRemoveUserButton5() {clickRemoveUserButton(4);}
    public void clickRemoveUserButton6() {clickRemoveUserButton(5);}

    //admin user management page web element assert methods (table)
    public boolean isTableSelectUserCheckboxDisplayed() {
        for (WebElement element : userTableSelectUserCheckboxes) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean isTableUsernameDisplayed() {
        for (WebElement element : userTableUsernameElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTableUserRoleDisplayed() {
        for (WebElement element : userTableUserRoleElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTableEmployeeNameDisplayed() {
        for (WebElement element : userTableEmployeeNameElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTableEmployeeStatusDisplayed() {
        for (WebElement element : userTableEmployeeStatusElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTableUserRemoveButtonDisplayed() {
        for (WebElement element : userTableRemoveUserButtons) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isTableEditUserButtonDisplayed() {
        for (WebElement element : userTableEditUserButtons) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
