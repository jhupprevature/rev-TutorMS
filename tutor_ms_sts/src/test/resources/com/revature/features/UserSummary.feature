Feature: View summary information of tutoring sessions

Background: 
    Given User is logged in

Scenario: Tutor views total hours worked
    Given User accountType is Tutor or Manager
    When User navigates to Tutoring Summary page
    Then Users total hours worked are displayed.

Scenario: Manager views total hours worked
    Given User role is Manager  
    When User navigates to Tutoring Summary page
    And User clicks Show Tutors button
    Then A list of tutors and their total hours are displayed.

#This is a Planned Goal
Scenario: Student views hours spent in tutoring
	Given User role is student
	When Clicks on Tutoring Summary page
	Then User sees their hours in tutoring