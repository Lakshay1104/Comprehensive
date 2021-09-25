Feature: Validate Cart

Scenario: Verify Add to cart of site
Given Initialize webdriver
And open the Urban Ladder website
When You reach site hover over the Bedroom section and click on SingleBeds
And then click on the product of interest
And click on Add to cart
Then Verify if product is successfully added to the cart