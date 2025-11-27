Feature: Login functionality
    
Scenario Outline: Login with different valid credentials
Given the user in the login window
When user enters valid "<username>" and valid "<password>"
Then user is navigated to products page

Examples:
	| username					| password		|
	| standard_user 			| secret_sauce  |
	| problem_user  			| secret_sauce  |
	| performance_glitch_user	| secret_sauce	|
	| error_user				| secret_sauce	|
	| visual_user				| secret_sauce	|



Scenario Outline: Login with different invalid credentials
Given the user in the login page
When the user enters invalid "<username>" and invalid "<password>"
Then the user gets error message "<expectedError>"

Examples:
	| username			| password		| expectedError																	|
	| locked_out_user	| secret_sauce	| Epic sadface: Sorry, this user has been locked out.							|
	| 					|				| Epic sadface: Username is required											|
	| standard_user		|				| Epic sadface: Password is required											|
	| 					| secret_sauce  | Epic sadface: Username is required											|
	|abc				| gshs			| Epic sadface: Username and password do not match any user in this service		|
