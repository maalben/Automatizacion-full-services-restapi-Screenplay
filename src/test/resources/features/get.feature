Feature: Information get individual user

  Scenario: Send information get individual user with response success
    Given Load customer information
      | id |
      | 1  |
    When Call Get user API
    Then Should see the code 200
    And Validate quantity key is 2
    And Validate schema request "GetJsonSchema"
    And Validate field get response api
    And Validate get response contain data expected
