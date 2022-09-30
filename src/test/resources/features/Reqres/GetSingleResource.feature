Feature: Get Single User
  @Tugas @PositiveCase
  Scenario Outline: GET single resource with valid id
    Given Get single resource with id <id>
    When Send request get single resource
    Then API should return response 200 OK
    And Response body should contain id <id>
    And Get single resource assert json validation
    Examples:
      |id|
      |3 |
      |4 |

  @Tugas @NegativeCase
  Scenario Outline: GET single resource with invalid id
    Given Get single resource with invalid id "<id>"
    When Send request get single resource
    Then API should return response 404 Not Found
    Examples:
      |id|
      |300|
      |@#$|
      |   |