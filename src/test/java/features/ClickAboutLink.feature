Feature: Click on About link

  Scenario: User Logs in and clicks on about link
    Given User logs in
    When User clicks on burger menu
    And User clicks on about link
    Then User sees About page