package com.orangehrmlive.demo.opensource.pages;

import com.orangehrmlive.demo.opensource.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Utility {
    private static final Logger log = LogManager.getLogger(DashboardPage.class.getName());

    public DashboardPage() {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement dashboardText;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logOut;
    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement profileTab;

    public String getDashbordText() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get dashboard text");
        return getTextFromElement(dashboardText);
    }

    public void clickOnProfile() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on profile");
        clickOnElement(profileTab);
    }

    public void mouseHoverAndClickOnLogOut() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Click on logout tab");
        mouseHoverToElementAndClick(logOut);
    }

}
