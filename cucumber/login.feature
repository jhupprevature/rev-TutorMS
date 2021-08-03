Feature: Login

Background: 
    Given User is on Login page

Scenario: Registered User, Successful Login
    When User inputs valid email
    * User inputs valid password
    * User clicks login button
    Then User is re-directed to role-appropriate home page.

Scenario: Registered User, Failed Login
    When User inputs invalid email
    * User inputs invalid password
    * User clicks login button
    Then a Login failure message is displayed.

#This feature will change after MVP (Tutor users must be approved by Managers).
Scenario: New User Registration
    When User clicks "Register new user"
    And User completes registration form
    Then new User is created
    And a Registration confirmation message is displayed
    And user is redirected to role-appropriate home page.
