@logout
Feature: Logout functionality

Scenario: Verify logout
Given the user in the login window
When user enters valid "standard_user" and valid "secret_sauce"
And user clicks logout
Then user navigated to login page