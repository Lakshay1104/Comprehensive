Feature: Validate Title

Scenario: Verify title of site
Given Initialize webdriver
And open the Urban Ladder website
When You reach site get the title of the site
Then Verify if the title contains site name