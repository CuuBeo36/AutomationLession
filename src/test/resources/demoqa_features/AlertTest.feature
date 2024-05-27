Feature: AlertTest

#  Background:
#    Given User go to Home page

  @NormalAlert
  Scenario: Normal Alert
    When User go to Alert page
    Then Verify normal alert is displayed
    

  @TimerAlert
  Scenario: Timer Alert
    When User go to Alert page
    Then Verify Timer alert is displayed
    

  @ConfirmAlertOK
  Scenario: Confirm Alert OK
    When User go to Alert page
    Then Verify Confirm alert OK
    

  @PromptBox
  Scenario: PromptBox
    When User go to Alert page
    Then Verify Prompt Box
    




