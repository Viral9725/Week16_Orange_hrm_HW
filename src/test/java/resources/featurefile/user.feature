Feature: User Test

  As a user I want to create and delete record.

  Background:
    Given I am Login Page
    When I enter username "Admin"
    And I enter password "admin123"
    And I click on login tab

  @smoke @regression
  Scenario: Admin should add user successfully
    And I click on admin tab
    Then I should be navigated to "System Users" page
    And I click on add button
    Then I should be navigated to the "Add User" Page
    And I select user role "Admin"
    And I enter employee name "Peter"
    And I enter user name "Ananya Dash"
    And select user status "Disabled"
    And I enter new password "Admin@123"
    And I enter confirm password "Admin@123"
    And I click on save button
    Then I should see the message "Successfully Saved"

  @smoke @regression
  Scenario: Search the created user and verify it
    And I click on admin tab
    Then I should be navigated to "System Users" page
    And I click on add button
    And I select user role "Admin"
    And I enter employee name "Ananya Dash"
    And select user status "Disabled"
    Then I should see the employee name ""

  @sanity @regression
  Scenario: Admin should be able to delete the user successfully
    And I click on admin tab
    Then I should be navigated to "System Users" page
    And I select user role "Admin"
    And I enter employee name on system user page "Peter"
    And I click on search button
    Then I verify user displayed in the list
    And I click on user check box
    And I click on delete button
    And I click on ok button
    Then I verify message displayed "Successfully Deleted"

  @regression
  Scenario: Search the deleted user and verify the message no record found
    And I click on admin tab
    Then I should be navigated to "System Users" page
    And I enter employee name on system user page "Charlie"
    And I select user role "Admin"
    And I select user status on "Enabled"
    And I click on search button
    And I verify the message "No Records Found"
