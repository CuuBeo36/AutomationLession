Feature: Full flow

  Scenario: Get email from API then register on App
    Given Set up the API URL
    When Send GET request to the API to get email
    Then Login App mobileWeb by email from API