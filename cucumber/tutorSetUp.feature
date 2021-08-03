#These are Planned Goals

Feature: Tutor Sets up Schedule and Courses

Background: 
    Given User is signed in as a tutor

Scenario: Tutor can set a schedule

	Given: Signed in as a tutor
	And: Viewing Schedules Tab
	When: Clicks on create a schedule
	Then: Schedule is created

Scenario: Tutor sets available courses

	Given: Signed in as a tutor
	And: Viewing the tutor's courses
	When: Clicks on set available
	Then: Course becomes available

Scenario: Tutor logs a walk-in session

	Given: Signed in as a tutor
	And: Viewing the tutor's courses
	When: Clicks on a walk-in course
	And: Clicks log hours
	And: User inputs hours worked
	Then: Course sets hours worked