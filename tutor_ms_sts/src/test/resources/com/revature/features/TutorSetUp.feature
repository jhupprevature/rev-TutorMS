#These are Planned Goals

Feature: Tutor Sets up Schedule and Courses

Background: 
    Given User is signed in as a tutor

Scenario: Tutor can set a schedule

	Given Viewing Schedules Tab
	When Clicks on create a schedule
	Then Schedule is created

Scenario: Tutor edits supported courses

	Given Viewing the tutors courses
	When Clicks on set available
	Then Tutor can edit supported course list

Scenario: Tutor updates supported courses
	Given User is viewing course list
	And User is finished editing course list
	When User clicks Save Changes button
	Then Tutors Course list is updated

Scenario: Tutor logs a walk-in session

	Given Viewing the tutors sessions
	When Clicks on add walk-in session
	And User inputs session information
	Then new Session is created