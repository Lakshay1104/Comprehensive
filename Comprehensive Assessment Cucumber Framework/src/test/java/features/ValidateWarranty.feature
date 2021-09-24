Feature: Validate ChangeInPrice

Scenario: Verify Change in price according to size
Given Initialize webdriver
And open the Urban Ladder website
When You reach site hover over the Bedroom section and click on All mattresses
And then click on the product you are interested in
Then verify if warranty of product is visible
