@product
Feature: product page

Background: 
Given the user in the login window
When user enters valid "standard_user" and valid "secret_sauce"


Scenario: Verify product page title
Then the product page title is verified

Scenario: Verify product list is displayed
Then the product list is verified

Scenario: Verify product details
Then the product details is verified