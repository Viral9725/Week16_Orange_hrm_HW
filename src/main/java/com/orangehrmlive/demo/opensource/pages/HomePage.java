package com.orangehrmlive.demo.opensource.pages;

import com.orangehrmlive.demo.opensource.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Admin']")
    WebElement adminTab;
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsers;

    public void clickOnAdminTab() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on admin tab");
        clickOnElement(adminTab);
    }

    public String getSystemUserText() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get System User text ");
        return getTextFromElement(systemUsers);
    }





}
