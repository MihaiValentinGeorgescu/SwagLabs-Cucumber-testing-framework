Feature: Login and log out functionality

  Scenario: Login and log out from page
    Given The user enters the page
    When The user enters valid credentials then clicks on the log in button
    And  Then user clicks on menu and logs out
    Then the user should get back the before screen