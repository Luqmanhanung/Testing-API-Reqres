Feature: Get single User
  @Tugas @PositiveCase
  Scenario Outline: GET single user with valid id
    Given Get single user with id <id>
    When Send request get single user
    Then API should return response 200 OK
    And Response body should contain id <id>
    And Get single user assert json validation
    Examples:
      |id|
      |3 |
      |4 |

  @Tugas @NegativeCase
  Scenario Outline: GET single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user
    Then API should return response 404 Not Found
    Examples:
      |id|
      |300|
      |#!a|
      |   |