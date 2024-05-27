Feature: WebTables

#  Background:
#    Given User go to Home page

  @AddNewRecord
  Scenario: Add New Record
    When User go to WebTables page
    And User enter registration form
    Then Verify added data
   


  @DeleteRecord1
  Scenario: Verify delete a record 1
    When User go to WebTables page
    Then Verify delete a record
   
