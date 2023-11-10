Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|'vidya.7685@gmail.com'|'Bellatrix$12345'|

Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account"


Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|Dashboard|
|Orders|
|Downloads|
|Addresses|
|Account details|
|Logout|
And accounts section count should be 6