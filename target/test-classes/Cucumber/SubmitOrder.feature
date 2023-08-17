@tag
Feature: Purchase the order from Ecommerce website

Background: 
Given I landed on the ecommerce page

@Regression
Scenario Outline: Positive Test of submitting the order
Given Logged in with username <username> and password <password>
When I add the product <ProductName> to the cart
And checkout <ProductName> and select the country <Country> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

Examples:
|username					|password		|ProductName		|Country		|
|shreyasdoshi48@gmail.com	|Mkyasv@1234	|ZARA COAT 3		|india			|
|sswarali05@gmail.com		|Ssd@12345		|ADIDAS ORIGINAL	|aus			|

