

Feature: Login functionality

Scenario: Login page title
Given User navigates to login page
When user gets the title of the page
Then page title should contains "My account"

Scenario: Forgot Password link
Given User navigates to login page
Then forgot your password link should be displayed

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username	|password	|
|'vidya.7685@gmail.com'|'Bellatrix$12345'|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario Outline:  Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
Examples:
|username|
|'vidya.7685@gmail.com'|


Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentails
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch 