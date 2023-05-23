package com.orangehrmlive.demo.opensource.pages;

import com.orangehrmlive.demo.opensource.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddUserPage.class.getName());

    public AddUserPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    public void selectUserRole(String role) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + role + "')]"));
    }

    public void enterEmployeeName(String name) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter employee name :");
        sendTextToElement(employeeName, name);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + name + "')]"));
    }

    public void selectUserStatus(String status) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[2]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + status + "')]"));
    }

    public void enterPassword(String name) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter Password :");
        sendTextToElement(password, name);
    }

    public void enterConfirmPassword(String name) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter confirm password");
        sendTextToElement(confirmPassword, name);
    }

    public void clickOnSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on save button");
        clickOnElement(saveButton);
    }

    public void enterUserName(String name) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter User name");
        sendTextToElement(userName, name);
    }

    public String getSuccessfulText() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(By.xpath("//*[@id='oxd-toaster_1']/div"));
        //return getTextFromAlert();
    }

    public String verifyUserDisplay(String name) throws InterruptedException {
        Thread.sleep(3000);
        log.info("Verify user displayed.");
        return employeeName.getText();

    }
}
