Feature: Login functionality on OrangeHRM

  Scenario: Successful login with valid credentials
    Given the user is on the OrangeHRM login page
    When the user enters valid credentials
    And clicks the Login button
    Then the user should be logged in successfully