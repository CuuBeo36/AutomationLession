Feature: LoginTest

#  Background:
#Given User get email from Web


  @LoginByWebEmail
  Scenario: Login with wrong account which get from web Email
    When User get email from Web
    And User login by WebEmail
    Then Verify wrong message


#  @LoginInWeb
#  Scenario: Open browser on Device
#    When User open browser on Device


