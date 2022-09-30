Feature: Get list users
  @Tugas @PositiveCase
  Scenario Outline: GET list user with valid page
    Given Get list user with page <Parameter>
    When Send request get list user
    Then API should return response 200 OK
    And Response body should contain id <Id>, firstname "<Firstname>", lastname "<Lastname>" and email "<Email>"
    And Response body page should be <Parameter>
    And Get list user assert json validation
    Examples:
      |Id|Parameter|Firstname|Lastname|Email|
      |3 |1        |Emma     |Wong   |emma.wong@reqres.in|
      |9 |2        |Tobias   |Funke  |tobias.funke@reqres.in|

  @Latihan @PositiveCase
  Scenario: GET list user with valid page
    Given Get list user with page 1
    When Send request get list user
    Then API should return response 200 OK
    And Response body should contain id 3, firstname "Emma", lastname "Wong" and email "emma.wong@reqres.in"
    And Response body page should be 1
    And Get list user assert json validation

  @Tugas @NegativeCase
  Scenario: GET list user with invalid page
    Given Get list user with page "ad"
    When Send request get list user
    Then API should return response 404 Not Found

  @Tugas @NegativeCase
  Scenario: GET list user not found
    Given Get list user with page 23
    When Send request get list user
    Then API should return response 404 Not Found

  @Tugas @PositiveCase
  Scenario Outline: GET list user with predetermined time delay
    Given Get list user with time delay <delay> second
    When Send request get list users with delay
    Then API should return response 200 OK
    And Get list user assert json validation
    Examples:
      |delay|
      |3    |
      |10   |
      |32   |

  @Tugas @PositiveCase
  Scenario: GET list user with maximum time delay
    Given Get list user with time delay 30 second
    When Send request get list users with delay
    Then API should return response status code 503 Service Unavailable