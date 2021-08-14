Feature: Login

Background: 
    Given User is on Login page

Scenario: Registered User, Successful Login
    When User inputs valid email
    And User inputs valid password
    And User clicks Login button
    Then User is re-directed to role-appropriate home page.

Scenario: Registered User, Failed Login
    When User inputs invalid email
    And User inputs invalid password
    And User clicks login button
    Then a Login failure message is displayed.

#This feature will change after MVP (Tutor users must be approved by Managers).
Scenario: New User Registration
    When User clicks Register new user
    And User completes registration form
    Then new User is created
    And a Registration confirmation message is displayed
    And User is redirected to role-appropriate home page.