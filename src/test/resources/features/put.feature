Feature: Information put individual user

  Scenario: Send information put individual user with response success
    Given Load customer information
      | name     | job    |
      | morpheus | leader |
    When Call Put user API with customer id 2
    Then Should see the code 200
    And Validate quantity key is 3
    And Validate schema request "PutJsonSchema"
    And Validate field put response api
    And Validate put response contain data expected