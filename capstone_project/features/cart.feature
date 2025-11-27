@cart
Feature: Shopping cart functionality

Background:
Given the user in the login window
When user enters valid "standard_user" and valid "secret_sauce"

Scenario: Add a product to cart
When user adds "Sauce Labs Backpack" to the cart
Then "Sauce Labs Backpack" should be added to cart and the cart icon should show "1"

Scenario: Remove a product from cart
When user removes "Sauce Labs Backpack" from cart
Then "Sauce Labs BackPack" is removed and cart icon becomes ""

