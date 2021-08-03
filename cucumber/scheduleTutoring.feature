Feature: Schedule tutoring sessions

Background: 
    Given User role is student

Scenario: Student searches for tutor
    When User clicks "Search for Tutors"
    And Student inputs criteria
    Then A list of tutors matching criteria are displayed.

Scenario: Student views tutor schedule
    Given User is viewing a Tutor's page
    When User clicks "View Availability"
    Then Tutor's availability is displayed

#Add stretch of denying or requesting a reschedule of a tutoring session?
Scenario: Student schedules tutoring session
    Given User is viewing a Tutor's page
    When User clicks "Schedule Tutoring Session"
    And Student completes optional request form
    Then Tutoring session is created
    And Tutor is notified of scheduled session at next login