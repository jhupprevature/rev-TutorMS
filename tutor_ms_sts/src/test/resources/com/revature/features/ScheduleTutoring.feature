Feature: Schedule tutoring sessions
    
Scenario: Student searches for tutor
		Given User is on Scheduling page
    When User clicks Search for Tutors
    And Student inputs "Law" criteria
    Then A tutor matching criteria is displayed.

Scenario: Student views tutor schedule
    When User clicks on a tutor
    Then Tutors schedule is displayed

Scenario: Student schedules tutoring session
    When User clicks Schedule Tutoring Session
    Then Tutoring session is created