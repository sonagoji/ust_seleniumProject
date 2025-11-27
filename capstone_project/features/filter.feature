@filter
Feature: Filtering products

Background:
Given the user in the login window
When user enters valid "standard_user" and valid "secret_sauce"

Scenario: Filter products by a to z
When user selects filter "Name (A to Z)"
Then products displayed in alphabetical order

Scenario: Filter products by a to z
When user selects filter "Name (Z to A)"
Then products displayed in reverse alphabetical order

Scenario: Filter products by a to z
When user selects filter "Price (low to high)"
Then products displayed in ascending price order

Scenario: Filter products by a to z
When user selects filter "Price (high to low)"
Then products displayed in descending price order