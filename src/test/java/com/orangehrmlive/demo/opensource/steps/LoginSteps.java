package com.orangehrmlive.demo.opensource.steps;

import com.orangehrmlive.demo.opensource.pages.DashboardPage;
import com.orangehrmlive.demo.opensource.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    @When("^I enter username \"([^\"]*)\"$")
    public void iEnterUsername(String userName) throws InterruptedException {
        new LoginPage().enterUserName(userName);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) throws InterruptedException {
        new LoginPage().enterPassword(password);
    }

    @And("^I click on login tab$")
    public void iClickOnLoginTab() throws InterruptedException {
        new LoginPage().clickOnLogin();
    }

    @Then("^I should navigate to \"([^\"]*)\" page$")
    public void iShouldNavigateToPage(String expText) throws InterruptedException {
        Assert.assertEquals(new DashboardPage().getDashbordText(), expText);
    }

    @Then("^I should see the logo$")
    public void iShouldSeeTheLogo() throws InterruptedException {
        Assert.assertTrue(new LoginPage().verifyCompanyLogoIsDisplayed());
    }

    @And("^I click on profile$")
    public void iClickOnProfile() throws InterruptedException {
        new DashboardPage().clickOnProfile();
    }

    @And("^I click on logout$")
    public void iClickOnLogout() throws InterruptedException {
        new DashboardPage().mouseHoverAndClickOnLogOut();
    }

    @Then("^I should be able to logout from the website successfully$")
    public void iShouldBeAbleToLogoutFromTheWebsiteSuccessfully() {
        Assert.assertTrue(new LoginPage().verifyLoginPanel());
    }
}
