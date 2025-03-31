Feature: Validateing the Application logo

Background: Navigating to Clothing & Accessories
Given Lauch the application RSC "https://www.rsc.org.uk/"
When user Accept or Dismiss the cookies
Then Validate user lands on the Homepage "https://www.rsc.org.uk/"



@smoke
Scenario: Validateing the Application logo fontcolor size and height
#Then validate the logo Background color
Then validate the font weight
And validate the font size in the app
And validate the font color in the app

