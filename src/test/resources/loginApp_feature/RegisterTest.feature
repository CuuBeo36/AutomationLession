Feature: RegisterTest

#  Background: Test Register
#    Given Setup device


  @RegisterMobile
  Scenario: User register new account mobile
    When Setup device
    When User register new account
    Then Verify login success
#    Then Close application

  @RegisterBrowserStack
  Scenario: User register new account browserstack
    When Setup browserstack device
    When User register new account
    Then Verify login success
    Then Close application


  @RegisterEmptyEmail
  Scenario: User register new account without email
    When User register new account but empty email
    Then Verify message empty email
    #    Then Close application


