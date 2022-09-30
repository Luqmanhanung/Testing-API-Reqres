Feature: Put Update user
  @Tugas @NegativeCase
  Scenario Outline: PUT Update user with invalid id
    Given Put update user with invalid id "<id>" and with valid json file
    When Send request put update user
    Then API should return response 400 BAD REQUEST
    Examples:
      |id|
      |@!|
      |sd|
      |  |

  @Latihan @PositiveCase
  Scenario: PUT Update user with valid Json File
    Given Put update user with id 1 and with valid json file
    When Send request put update user
    Then API should return response 200 OK
    And Response body should contain name "Luqman Hanung Asidiq" and job "Quality Assurance Engineer"
    And Put update user assert json validation

  @Tugas @NegativeCase
  Scenario: PUT update user without valid Json File
    Given Put update user with id 1 and without valid json file
    When Send request put update user
    Then API should return response 400 BAD REQUEST

  @Tugas @NegativeCase
  Scenario: PUT update user with invalid Json File
    Given Put update user with id 1 and with invalid json file
    When Send request put update user
    Then API should return response 400 BAD REQUEST