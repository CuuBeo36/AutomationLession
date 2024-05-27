Feature: FillingOutForm

  Background:
    Given User go to FillingOutForm Page

  @FillingForm0
  Scenario: Submit form 0 (no confirmation)
    When User submit form 0
    Then Verify form 0 is submitted successfully
    And User close a browser



  @FillingForm1
  Scenario: Submit form 1 (with confirmation)
    When User submit form 1
    Then Verify form 1 is submitted successfully
    And User close a browser