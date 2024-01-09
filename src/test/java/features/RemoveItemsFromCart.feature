Feature: Remove items from cart

  Scenario: User logs in, shops an item and then changes his mind and removes it
    Given User logs in to the website to shop
    When Shops an item and presses on the cart link
    And User removes item and continues shopping
    Then Cart is empty