Feature: View summary information of tutoring sessions

Scenario: Tutor views total hours worked
    Given User role is Tutor or Manager
    When User is on "Tutoring Summary" page
    Then User's total hours worked are displayed.

Scenario: Manager views total hours worked
    Given User role is Manager  
    When User is on "Tutoring Summary" page
    And User clicks "Show Tutors" button
    Then A list of tutors and their total hours are displayed.