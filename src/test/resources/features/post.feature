Feature: Information post user

  Scenario Outline: Send information post user with response success
    Given Load customer information
      | name   | job   |
      | <name> | <job> |
    When Call Post user API
    Then Should see the code 201
    And Validate quantity key is 4
    And Validate schema request "PostJsonSchema"
    And Validate field post response api
    And Validate post response contain data initial

    Examples:
      | name     | job    |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1
   |morpheus   |leader|
