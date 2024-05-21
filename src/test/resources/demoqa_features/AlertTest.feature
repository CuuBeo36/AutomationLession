Feature: AlertTest

  Background:
    Given User go to Home page

  @NormalAlert
  Scenario: Normal Alert
    When User go to Alert page
    Then Verify normal alert is displayed
    And User closes browser

  @TimerAlert
  Scenario: Timer Alert
    When User go to Alert page
    Then Verify Timer alert is displayed
    And User closes browser

  @ConfirmAlertOK
  Scenario: Confirm Alert OK
    When User go to Alert page
    Then Verify Confirm alert OK
    And User closes browser

  @PromptBox
  Scenario: PromptBox
    When User go to Alert page
    Then Verify Prompt Box
    And User closes browser




