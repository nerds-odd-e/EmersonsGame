Feature: View Races

  Scenario: View races
    Given I have races available
    When  I try to view all races
    Then  I must see all races
