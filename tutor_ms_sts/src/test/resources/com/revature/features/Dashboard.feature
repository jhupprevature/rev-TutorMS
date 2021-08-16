Feature: Account can update

Background: 
    Given User is logged in
    
   
Scenario: Successfuly change Account info
    When User inputs a new username
    And User clicks the Update button
    Then User's username is updated on header