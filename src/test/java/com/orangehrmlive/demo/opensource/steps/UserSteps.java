package com.orangehrmlive.demo.opensource.steps;

import com.orangehrmlive.demo.opensource.pages.AddUserPage;
import com.orangehrmlive.demo.opensource.pages.AdminPage;
import com.orangehrmlive.demo.opensource.pages.HomePage;
import com.orangehrmlive.demo.opensource.pages.ViewSystemUsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.UUID;


public class UserSteps {
    String name = UUID.randomUUID().toString();

    @And("^I click on admin tab$")
    public void iClickOnAdminTab() throws InterruptedException {
        new HomePage().clickOnAdminTab();
    }

    @Then("^I should be navigated to \"([^\"]*)\" page$")
    public void iShouldBeNavigatedToPage(String exceptedMessage) throws InterruptedException {
        Assert.assertEquals(exceptedMessage, new HomePage().getSystemUserText());
    }

    @And("^I click on add button$")
    public void iClickOnAddButton() throws InterruptedException {
        new AdminPage().clickOnAddButton();
    }

    @Then("^I should be navigated to the \"([^\"]*)\" Page$")
    public void iShouldBeNavigatedToThePage(String exceptedMessage) throws InterruptedException {
        Assert.assertEquals(exceptedMessage, new AdminPage().getAddUserText());
    }

    @And("^I select user role \"([^\"]*)\"$")
    public void iSelectUserRole(String role) throws InterruptedException {
        new AddUserPage().selectUserRole(role);
    }

    @And("^I enter employee name \"([^\"]*)\"$")
    public void iEnterEmployeeName(String eName) throws InterruptedException {
        new AddUserPage().enterEmployeeName(eName);
    }

    @And("^I enter user name$")
    public void iEnterUserName() throws InterruptedException {
        new AddUserPage().enterUserName(name);
    }

    @And("^select user status \"([^\"]*)\"$")
    public void selectUserStatus(String status) throws InterruptedException {
        new AddUserPage().selectUserStatus(status);
    }

    @And("^I enter new password \"([^\"]*)\"$")
    public void iEnterNewPassword(String password) throws InterruptedException {
        new AddUserPage().enterPassword(password);
    }

    @And("^I enter confirm password \"([^\"]*)\"$")
    public void iEnterConfirmPassword(String cPassword) throws InterruptedException {
        new AddUserPage().enterConfirmPassword(cPassword);
    }

    @And("^I click on save button$")
    public void iClickOnSaveButton() throws InterruptedException {
        new AddUserPage().clickOnSaveButton();
    }

    @Then("^I should see the message \"([^\"]*)\"$")
    public void iShouldSeeTheMessage(String expMsg) throws InterruptedException {
        String msg = new AddUserPage().getSuccessfulText();
        String[] actMsg = msg.split("\n");
        Assert.assertEquals(expMsg, actMsg[1]);
    }

    @Then("^I should see the employee name \"([^\"]*)\"$")
    public void iShouldSeeTheEmployeeName(String expName) throws InterruptedException {
        Assert.assertEquals(new AddUserPage().verifyUserDisplay(expName), expName);
    }

    @And("^I enter employee name on system user page \"([^\"]*)\"$")
    public void iEnterEmployeeNameOnSystemUserPage(String eName) throws InterruptedException {
        new ViewSystemUsersPage().enterEmployeeName(eName);

    }

    @And("^I click on search button$")
    public void iClickOnSearchButton() throws InterruptedException {
        new ViewSystemUsersPage().clickOnSearchButton();
    }

    @Then("^I verify user displayed in the list$")
    public void iVerifyUserDisplayedInTheList() {
        Assert.assertTrue(new ViewSystemUsersPage().verifyUserIsDisplayInList());
    }

    @And("^I click on user check box$")
    public void iClickOnUserCheckBox() throws InterruptedException {
        new ViewSystemUsersPage().clickOnSearchButton();
    }

    @And("^I click on delete button$")
    public void iClickOnDeleteButton() throws InterruptedException {
        new ViewSystemUsersPage().clickOnDeleteButton();
    }

    @And("^I click on ok button$")
    public void iClickOnOkButton() throws InterruptedException {
        new ViewSystemUsersPage().clickOnOkButton();
    }

    @Then("^I verify message displayed \"([^\"]*)\"$")
    public void iVerifyMessageDisplayed(String expMsg) throws InterruptedException {
        String msg = new ViewSystemUsersPage().getSuccessfulText();
        String[] actualMsg = msg.split("\n");
        Assert.assertEquals(expMsg, actualMsg[1]);
    }

    @And("^I select user status on \"([^\"]*)\"$")
    public void iSelectUserStatusOn(String status) throws InterruptedException {
        new ViewSystemUsersPage().selectUserStatus(status);
    }

    @And("^I verify the message \"([^\"]*)\"$")
    public void iVerifyTheMessage(String expMsg) throws InterruptedException {
        String msg = new ViewSystemUsersPage().getNoRecordFoundText();
        String[] actMsg = msg.split("\n");
        Assert.assertEquals(expMsg, actMsg[1]);
    }


    @And("^I enter user name \"([^\"]*)\"$")
    public void iEnterUserName(String eName) throws InterruptedException {
        new AddUserPage().enterUserName(eName);
    }
}
