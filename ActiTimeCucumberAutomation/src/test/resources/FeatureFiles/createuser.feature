# Feature Name
# Author
# Date Created
Feature: Create User Functionality
Description This feature validates Create User and Delete User Functionalities
Scenario: Verify the Create User and Delete User 
Given I launch the chrome Browser
And I navigate the application url
When I enter username in username text field
And I enter password in password text field
And I click on Login button
Then I find the home page
And I minimize the flyout window
And I click on create User
Then I enter the user details
And I click on create user button
And I click on User 
And I click on delete User
When I click on Logout link
Then I find the login page
And I close the application