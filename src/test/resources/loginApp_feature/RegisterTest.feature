Feature: RegisterTest

  Background: Test Register
    Given Setup device


  @Register
  Scenario: User register new account
    When User register new account
    Then Verify login success
#    Then Close application

  @RegisterEmptyEmail
  Scenario: User register new account without email
    When User register new account but empty email
    Then Verify message empty email
    #    Then Close application


