Feature: Login functionality

  Scenario: User can login with valid credentials
    Given the app is launched
    When the user enters "test@example.com" and "password123"
    And the user clicks the login button
    Then the user is logged in successfully