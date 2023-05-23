Feature: Login Test

  As a user I want to login to Orange Hrm Website

  Background:
    Given I am Login Page

  @smoke @regression
  Scenario: User should login successfully
    When I enter username "Admin"
    And I enter password "admin123"
    And I click on login tab
    Then I should navigate to "Dashboard" page

  @sanity @regression
  Scenario: User should be able to see Logo on Login page
    When I am Login Page
    Then I should see the logo

  @regression
  Scenario: User should logout from the website successfully
    When I enter username "Admin"
    And I enter password "admin123"
    And I click on login tab
    And I click on profile
    And I click on logout
    Then I should be able to logout from the website successfully