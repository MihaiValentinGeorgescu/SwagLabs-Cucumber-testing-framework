Feature: Login functionality with wrong credentials

  Scenario: Login with wrong credentials
    Given the user is on the swaglabs login page
    When the user enters invalid credentials
    And clicks the Login button for invalid credentials
    Then the user should be see error login