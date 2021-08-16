Feature: Looking at Profile

  Scenario: Login
    Given User is on login page
    When User clicks search for username
    And User enters "amcorkill4" for username
    And User clicks search for password
    And User enters "Y4nj627QP" for password
    And User clicks the login button
    Then User should be on Dashboard page

  Scenario: Go to Profile Page
    When User clicks username in top right corner
    And User clicks Profile
    Then User should be on Profile page
  