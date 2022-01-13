Feature: Information delete individual user

  Scenario: Send information delete individual user with response success
    Given Load customer information
      | id |
      | 1  |
    When Call Delete user API
    Then Should see the code 204