Feature: PATCH Update user
  @Tugas @PositiveCase
  Scenario: PATCH Update user with valid id
    Given Patch update user with id 1 and with valid json file
    When Send request patch update user
    Then API should return response 200 OK
    And Patch Response body should contain name "Justin Bieber"
    And Patch update user assert json validation

  @Tugas @NegativeCase
  Scenario Outline: PATCH Update user with invalid id
    Given Patch update user with id "<id>" and with valid json file
    When Send request patch update user
    Then API should return response 400 BAD REQUEST
    Examples:
      |id|
      |sS5|
      |$@2|