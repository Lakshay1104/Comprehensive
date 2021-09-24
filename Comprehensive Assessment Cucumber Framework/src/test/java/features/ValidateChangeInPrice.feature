Feature: Validate ChangeInPrice

Scenario: Verify Change in price according to size
Given Initialize webdriver
And open the Urban Ladder website
When You reach site hover over the Bedroom section and click on All mattresses
And then click on the product you are interested in
And Retrieve price of product
Then Change the size of product and retrieve the prize again
And verify if the price changes with size