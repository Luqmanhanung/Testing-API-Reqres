Feature: Register user
  @Tugas @PositiveCase
  Scenario: Register-successful
    Given register new user with valid json file
    When When Send request post register user
    Then API should return response 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Post register user assert json validation

  @Tugas @NegativeCase
  Scenario: Register-Unsuccessful
    Given register new user with invalid json file
    When When Send request post register user
    Then API should return response 400 BAD REQUEST
    And Response body should contain error message "Missing password"
    And Post register and login user error message missing password assert json validation