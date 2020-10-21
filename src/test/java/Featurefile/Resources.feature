
Feature: To validate the resources
  
  
  Scenario: Validate the post method
    Given Initialize base url and base path
    Then call the pojo class
    Then Get the Response for post method
    And Validate the Response using jsonpath
    

  