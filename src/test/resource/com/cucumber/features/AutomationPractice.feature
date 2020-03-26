Feature: Automation Practice functionality validation test case



Scenario Outline: User login to the Automation Practice application
Given User launches the browser
And User hit the given application url
When User clicks on SignIn link displayed in the home page
Then User verifies username field is enabled
And User verifies password field is enabled
When User enters the "<username>"
And User enters the '<password>'
And User click on SignIn button
Then User verifies whether username is present in the my account page
Examples:
|username|password|
|geethapriyababu@gmail.com|123456|
|yugendraG@gamil.com|yugendra|



 Scenario Outline:
 User place order using search
 Then User verifies search field is displayed
 And User verifies search field is enabled
 When User enters "<Products>" in the search field
 And User clicks on search button
 And User clicks on the image
 And User clicks on the plus symbol
 And User selects the M value from the size dropdownlist
 And User clicks on the color icon
 And User clicks on Addtocart button
 Examples:
 |Products|
 |Printed|
 |T-shirts|
 |Blouse|
 
 Scenario: User making the payment
 When User clicks on the Proceed to Checkout button
 And User clicks on the proceed to checkout button in the summary page
 And User clicks on the proceed to checkout button in the summary page
 And User clicks on the terms and conditions checkbox
 And User clicks on the procedd to checkout button in the shipping page
 And User clicks on the pay by bankwire in the payment page
 And User clicks on the confirm button
 Then User verifies order is complete
 
 Scenario: User logged out of the application
 When User clicks on the logout button
 Then User verifies the browser is quit
 