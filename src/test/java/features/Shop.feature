Feature: Shop and checkout
  Scenario: User puts items in the cart and then buys them
    Given User logs in with valid credentials to the website saucedemo
    When User shops and presses cart button
    And User presses chekout button and completes the form for checkout and presses contiue button
    Then User clicks finish button and sees final image for Pony Express Sauce Labs