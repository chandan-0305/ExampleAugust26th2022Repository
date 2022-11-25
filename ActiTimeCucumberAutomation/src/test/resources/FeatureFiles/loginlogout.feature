# Feature Name
# Author
# Date Created 
Feature: Login and Logout functionality
Description this features validaes Login and Logout functionalities
Scenario: Verify the Login functionality
Given I launch the chrome Browser
And I navigate the application url
When I enter username in username text field
And I enter password in password text field
And I click on Login button
Then I find the home page
And I minimize the flyout window

Scenario: Verify the Logout functionality
Given I find the home page
When I click on Logout link
Then I find the login page
And I close the application

