Feature: Delete user
  @Latihan @PositiveCase
  Scenario Outline: DELETE user With valid id
    Given Delete user with id <id>
    When Send request delete user
    Then API should return response 204 NO CONTENT
    Examples:
      |id|
      |2 |
      |3 |

  @Tugas @NegativeCase
  Scenario Outline: DELETE user With invalid id
    Given Delete user with id "<id>"
    When Send request delete user
    Then API should return response 400 BAD REQUEST
    Examples:
      |id|
      |40E|
      |EWQ#|
      |    |