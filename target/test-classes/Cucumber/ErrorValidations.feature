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