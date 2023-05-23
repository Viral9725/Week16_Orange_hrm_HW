package com.orangehrmlive.demo.opensource.pages;

import com.orangehrmlive.demo.opensource.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement logIn;

    /**
     * Enter Username
     *
     * @param value
     * @throws InterruptedException
     */
    public void enterUserName(String value) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter User Name");
        sendTextToElement(userName, value);
    }

    public void enterPassword(String value) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Enter Password");
        sendTextToElement(password, value);
    }

    public void clickOnLogin() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on login tab");
        clickOnElement(logIn);
    }

    public boolean verifyCompanyLogoIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
    }

    public boolean verifyLoginPanel(){
        return driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
    }

}
