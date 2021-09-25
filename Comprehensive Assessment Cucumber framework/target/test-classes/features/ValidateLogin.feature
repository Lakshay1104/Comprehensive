Feature: Validate Login

Scenario: Verify login feature of site
Given Initialize webdriver
And open the Urban Ladder website
When You reach site hover over login icon
Then click on login
And verify whether login feature is working