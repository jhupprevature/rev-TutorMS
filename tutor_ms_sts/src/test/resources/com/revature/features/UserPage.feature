Feature: View User profiles

Background:
    Given User is logged in

Scenario: User views another Users contact info
	Given User has selected another User profile.
	When User clicks View Contact Info
	Then Another Users contact info is displayed.

Scenario: User edits their contact info
    Given User is on their Profile page
    When User clicks Edit button
    Then User contact info is able to be edited

Scenario: User saves edits to contact info
    Given User has completed an edit
    When User clicks Save button
    Then User contact info is updated

#This is a Planned Goal
Scenario: Admin has all privilieges of other accounts

	Given Signed in as an admin
	And Viewing the manage Tab
	When Clicks on another accounts information
	Then Can manage the account's information