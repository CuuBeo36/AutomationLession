Feature: LoginTest

#  Background:
#Given User get email from Web


  @LoginTest
  Scenario: Login with wrong account
    When User get email from Web
    And User login by WebEmail
    Then Verify wrong message
