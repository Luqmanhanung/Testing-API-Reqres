Feature: Login user
  @Tugas @PositiveCase
  Scenario: Login - Successful
    Given login user with valid json file
    When Send request post login user
    Then API should return response 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Post login user assert json validation

  @Tugas @NegativeCase
  Scenario: Login - Unsuccessful
    Given login user with invalid json file
    When Send request post login user
    Then API should return response 400 BAD REQUEST
    And Response body should contain error message "Missing password"
    And Post register and login user error message missing password assert json validation
