Feature: Validate Subscription

Scenario: Verify Subscription of site
Given Initialize webdriver
And open the Urban Ladder website
When You reach site enter email for subscription
Then Verify if subscription has been successfull