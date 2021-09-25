Feature: Validate Order

Scenario: Verify Track order feature
Given Initialize webdriver
And open the Urban Ladder website
When You reach site click on Track Order
And enter OrderNo "32132131" and PhoneNo "8765487654" and click on Submit
Then Verify if the track order feature is working