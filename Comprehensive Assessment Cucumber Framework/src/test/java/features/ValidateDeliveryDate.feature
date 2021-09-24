Feature: Validate DeliveryDate

Scenario: Verify DeliveryDate feature
Given Initialize webdriver
And open the Urban Ladder website
When You reach site hover over the Bedroom section and click on All mattresses
And then click on the product you are interested in
Then Verify if delivery time of product is being shown
