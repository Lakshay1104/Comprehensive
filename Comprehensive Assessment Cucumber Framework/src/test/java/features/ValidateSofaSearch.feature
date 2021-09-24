Feature: Validate SofaSearch

Scenario: Verify search feature of site
Given Initialize webdriver
And open the Urban Ladder website
When You reach site search for "Sofa"
Then Verify if the products shown match the search