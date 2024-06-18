Feature: MobileWebTest

#  Background: Test Register
#    Given Setup device

  @AccessMobileWeb
  Scenario: User access mobileWeb
    When Setup mobile web device
    When User access mobile web
    Then Verify web title