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
    //user removal warning box text web element
    @FindBy(xpath = "//div[@id='app']/div[@role='dialog']//div[@role='document']/div[@class='orangehrm-text-center-align']/p")
    private WebElement userRemovalWarningText;
    //user removal warning box denial button web element
    @FindBy(xpath = "//div[@role='document']/div/button[1]")
    private WebElement userRemovalDenialButton;
    //user removal warning box confirm button web element
    @FindBy(xpath = "//div[@role='document']/div/button[2]")
    private WebElement userRemovalConfirmButton;
    //user deletion confirmation message web element
    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement userRemovalConfirmationMessage;
    //admin management page web elements
    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[1]")
    private WebElement usernameSearchBar;
    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[2]")
    private WebElement userRoleDropdownSelector;
    //admin option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
    private WebElement adminOption;
    //ESS option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[3]")
    private WebElement essOption;
    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[3]")
    private WebElement employeeNameSearchBar;
    @FindBy(xpath = "//div[@class='oxd-form-row']/div/div[4]")
    private WebElement statusDropdownSelector;
    //enabled status option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
    private WebElement enabledStatusOption;
    //disabled status option web element
    @FindBy(xpath = "(//div[@role='listbox']//child::div)[3]")
    private WebElement disabledStatusOption;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement resetSearchButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    //add new user button element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addUserButton;


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

    //user removal warning box confirm button click
    public void clickConfirmUserRemovalButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(userRemovalConfirmButton));
        userRemovalConfirmButton.click();
    }
    //user removal warning box denial button click
    public void clickAbortUserRemovalButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(userRemovalDenialButton));
        userRemovalDenialButton.click();
    }

    //add new user button click method
    public void clickAddNewUserButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton));
        addUserButton.click();
    }

    //user role dropdown selector click method
    public void clickUserRoleDropdownSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(720));
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdownSelector));
        userRoleDropdownSelector.click();
    }
    public void selectAdminOption() {adminOption.click();}
    public void selectESSOption() {essOption.click();}

    //user status dropdown selector
    public void clickStatusDropdownSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdownSelector));
        statusDropdownSelector.click();
    }
    public void selectEnabledOption() {enabledStatusOption.click();}
    public void selectDisabledOption() {disabledStatusOption.click();}

    //search user button click method
    public void clickSearchUserButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    //search user button click method
    public void clickResetSearchUserButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(600));
        wait.until(ExpectedConditions.elementToBeClickable(resetSearchButton));
        resetSearchButton.click();
    }

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
    public boolean isUsernameSearchBarDisplayed(){return usernameSearchBar.isDisplayed();}
    public boolean isUserRoleSelectorDisplayed(){return userRoleDropdownSelector.isDisplayed();}
    public boolean isEmployeeNameSearchBarDisplayed(){return employeeNameSearchBar.isDisplayed();}
    public boolean isEmployeeStatusSearchBarDisplayed(){return statusDropdownSelector.isDisplayed();}
    public boolean isResetSearchButtonDisplayed(){return resetSearchButton.isDisplayed();}
    public boolean isSearchButtonDisplayed(){return searchButton.isDisplayed();}
    public boolean isAddUserButtonDisplayed(){return addUserButton.isDisplayed();}

    //user removal warning box text getter
    public String getUserRemovalWarningBoxText(){return userRemovalWarningText.getText();}
    //user removal confirmation message text getter
    public String getUserRemovalConfirmationMessageText(){return userRemovalConfirmationMessage.getText();}

    //user role/status getters
    public String getSelectedAdminUserRole(){return adminOption.getText();}
    public String getSelectedESSUserRole(){return essOption.getText();}
    public String getSelectedEnabledStatus(){return enabledStatusOption.getText();}
    public String getSelectedDisabledStatus(){return disabledStatusOption.getText();}
}
