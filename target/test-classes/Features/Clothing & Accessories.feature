
Feature: Validateing the Clothing & Accessories

Background: Navigating to Clothing & Accessories
Given Lauch the application RSC "https://www.rsc.org.uk/"
When user Accept or Dismiss the cookies
Then Validate user lands on the Homepage "https://www.rsc.org.uk/"
When User Clicks the Shop Module one dim map
|value1|Shop|

@smoke
Scenario: Validateing the Clothing & Accessories Products
Then validate the Sub_Models of Shop
When User Clicks on Clothes&Accessories
Then Validate DropDown items Displayed
When User Clicks the Search functionality 
And User Provide the Keys one dim list
|Shirt|
Then validate items in the Description belongs to the Search 
@smoke
Scenario: Validateing the HomeWare Products 
When User Clicks on Books HomeWare and Gifts
Then Validate DropDown of HomeWare items Displayed
And Validate the DropDown List Out Model Related Items
When user clicks on All_HomeWare
Then validate Wheather it is move to the current page
When user clicks on Color
Then  Validate the CheckBoxes is Multiple
@smoke
Scenario Outline: Validateing the User
When User Clicks on the Account
And User provides the username "<username>"
And user provides the Password "<Password>"
And user click on Sign_in
#Then Validate the Crenditals
Examples:
|username   |password  |
|dharandhamu|9787857768|
|DhamoDharan|7397046057|
