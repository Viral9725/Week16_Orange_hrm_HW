package com.orangehrmlive.demo.opensource.pages;

import com.orangehrmlive.demo.opensource.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {

    private static final Logger log = LogManager.getLogger(ViewSystemUsersPage.class.getName());

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-container']//button[1]")
    WebElement deleteButton;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement okButton;
    @CacheLookup
    @FindBy(xpath = "//*[@id='oxd-toaster_1']//*")
    WebElement successText;
    @CacheLookup
    @FindBy(xpath = "//*[@id='oxd-toaster_1']/div")
    WebElement noRecord;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement userCheckBox;
    public void enterUserName(String value) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter User name :");
        sendTextToElement(userName,value);
    }

    public void selectUserRole(String role) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + role + "')]"));
    }

    public void enterEmployeeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter employee name");
        sendTextToElement(employeeName, name);
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + name + "')]"));
    }

    public void selectUserStatus(String status) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + status + "')]"));
    }

    public void clickOnSearchButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[normalize-space()='Search']"));
    }

    public boolean verifyUserIsDisplayInList(){
        return driver.findElement(By.xpath("//div[contains(text(),'Peter.Anderson')]")).isDisplayed();
    }

    public void clickOnUserCheckBox() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on user check box");
        clickOnElement(userCheckBox);
    }

    public void clickOnDeleteButton() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on delete button");
        clickOnElement(deleteButton);
    }

    public void clickOnOkButton() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on ok button");
        clickOnElement(okButton);
    }

    public String getSuccessfulText() throws InterruptedException {
        Thread.sleep(2000);
        log.info("Click on success text");
        return getTextFromElement(successText);
        //return getTextFromAlert();
    }

    public String getNoRecordFoundText() throws InterruptedException {
        Thread.sleep(1000);
        log.info("CLick on no record found text");
        return getTextFromElement(noRecord);
    }
}
