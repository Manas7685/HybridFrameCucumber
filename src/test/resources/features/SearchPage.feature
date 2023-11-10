Feature: Search functionality
Scenario: User searches for a valid product
Given User nevigate to homepage
When User enters valid product "Falcon 9" into Search box field
And User hits enter key
Then User should get valid products displayed on page
Scenario: User searches for an invalid product
Given User nevigate to homepage
When User enters invalid product "Honda" into Search box field
And User hits enter key
Then User should get a message about no product matching
#Scenario: User searches without any product
#Given User nevigate to homepage
#When User dont enter any product name into Search box field
#And User hits enter key
#Then User should get a message about no product matching
