@checkout
Feature: Checkout functionality

Background:
Given the user in the login window
When user enters valid "standard_user" and valid "secret_sauce"

Scenario: Successfull checkout
Given the user adds "Sauce Labs Backpack" to cart
When he proceeds to checkout with firstname "abc" lastname as "gvc" and postal code as "453678"
Then order confirmation is displayed


Scenario: Unsuccessfull checkout
Given the user adds "Sauce Labs Backpack" to cart
When he proceeds to checkout with firstname "abc" lastname as "gvc" and postal code as "w"
Then error message is displayed

