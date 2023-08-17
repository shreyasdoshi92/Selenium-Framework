@tag
Feature: Error Validations

@smoke
Scenario Outline: Negative Test of Login
Given I landed on the ecommerce page
When Logged in with username <username> and password <password>
Then "Incorrect email or password." message is displayed

Examples:
|username					|password		|
|shreyasdoshi48@gmail.com	|Mkyasv@134		|
|sswarali05@gmail.com		|Ssd@1245		|

@smoke
Scenario Outline: Negative Test of verifyProduct
Given I landed on the ecommerce page
When Logged in with username <username> and password <password>
And I add the product <ProductName> to the cart
Then <ProductName> is displayed on cart page

Examples:
|username					|password		|ProductName		|
|shreyasdoshi48@gmail.com	|Mkyasv@1234	|ZARA COAT 3		|
|sswarali05@gmail.com		|Ssd@12345		|ADIDAS ORIGINAL	|