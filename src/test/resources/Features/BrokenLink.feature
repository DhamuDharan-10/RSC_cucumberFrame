Feature: validate the urls in the HomePage


Background: Navigating to Clothing & Accessories
Given Lauch the application RSC "https://www.rsc.org.uk/"
When user Accept or Dismiss the cookies
Then Validate user lands on the Homepage "https://www.rsc.org.uk/"

@smoke
Scenario: validate the urls in application
Then validate the url is working or not