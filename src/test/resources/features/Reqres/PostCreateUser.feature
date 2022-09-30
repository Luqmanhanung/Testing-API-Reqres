Feature: POST Create user
  @Tugas @NegativeCase
  Scenario: POST create user with invalid credential
    Given Post create new user with invalid json file
    When Send request post create user
    Then API should return response 400 BAD REQUEST

  @Latihan @PositiveCase
  Scenario: POST create user valid credential
    Given Post create new user with valid json file
    When Send request post create user
    Then Api should return response 201 Created
    And Response body should contain name "Luqman Hanung" and job "Software QA Engineer"
    And Post create user assert json validation
