Feature: User uses the Calendar

	Background:
				Given User is on the Calendar tab
	
  Scenario: User adds an event
    When User clicks on a date
    And User clicks searchbar to enter title
    And User enters "Project 2" for title
    And User clicks searchbar to enter a color
    And User enters "red" for color
    And User clicks submit
    And User clicks the X button
    Then User should see event on Calendar
    
  Scenario: User deletes an event
  When User clicks on checkbox for deletion
  And User clicks on an event
  Then User should not see event on Calendar