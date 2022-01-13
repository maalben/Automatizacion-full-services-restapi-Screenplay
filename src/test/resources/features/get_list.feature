Feature: Information list get users

  Scenario: Send information list get users with response success
    Given Load customer information
      | page |
      | 1    |
    When Call Get user API
    Then Should see the code 200
    And Validate quantity key is 6
    And Validate schema request "GetListJsonSchema"
    And Validate fields get list response api
    And Validate list get response contain data expected
      | page | per_page | total | total_pages | support_url                        | support_text                                                             | id | email                  | first_name | last_name | avatar                                  |
      | 1    | 6        | 12    | 2           | https://reqres.in/#support-heading | To keep ReqRes free, contributions towards server costs are appreciated! | 1  | george.bluth@reqres.in | George     | Bluth     | https://reqres.in/img/faces/1-image.jpg |