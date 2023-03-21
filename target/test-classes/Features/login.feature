Feature: feature to test login functionality

  Scenario: Login test with valid credential
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to the home page
