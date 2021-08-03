Feature: Schedule tutoring sessions

Background: 
    Given User is on "Scheduling" page
    And User accountType is student
    

Scenario: Student searches for tutor
    When User clicks "Search for Tutors"
    And Student inputs criteria
    Then A list of tutors matching criteria are displayed.

Scenario: Student views tutor schedule
    Given User is viewing a Tutor's page
    When User clicks "View Availability"
    Then Tutor's availability is displayed

#This is a Planned Goal
Scenario: Student searches for walk-in availability

	Given: Signed in as a student
	And: Viewing the courses tab
	When: Clicks on search bar
	And: Types walk-in availability
	Then: Courses with walk-in availability are shown

#Add stretch of denying or requesting a reschedule of a tutoring session?
Scenario: Student schedules tutoring session
    Given User is viewing a Tutor's page
    When User clicks "Schedule Tutoring Session"
    And Student completes optional request form
    Then Tutoring session is created
    And Tutor is notified of scheduled session at next login