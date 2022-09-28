Feature: Request to API Reqres.in
  @Tugas @PositiveCase
  Scenario Outline: GET single list user with valid parameter (page)
    Given Get list user with page <Parameter>
    When Send request get single user
    Then API should return response 200 OK
    And Response body should contain id <Id>, firstname "<Firstname>", lastname "<Lastname>" and email "<Email>"
    And Response body page should be <Parameter>

  Examples:
      |Id|Parameter|Firstname|Lastname|Email|
      |3|1        |Emma     |Wong   |emma.wong@reqres.in|
      |9|2        |Tobias  |Funke  |tobias.funke@reqres.in|

  @Latihan @PositiveCase
  Scenario: GET single list user with valid parameter (page) (without outline scenario)
    Given Get list user with page 1
    When Send request get single user
    Then API should return response 200 OK
    And Response body should contain id 3, firstname "Emma", lastname "Wong" and email "emma.wong@reqres.in"
    And Response body page should be 1

  @Latihan @PositiveCase
  Scenario: POST create user with valid credential (without outline scenario)
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "Luqman Hanung" and job "Software QA Engineer"

  @Tugas @PositiveCase
  Scenario Outline: POST create user valid credential
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "<name>" and job "<job>"
  Examples:
    |name          |job                 |
    |Luqman Hanung |Software QA Engineer|

  @Tugas @NegativeCase
  Scenario: GET single list user with invalid parameter (page)
    Given Get list user with page "ad"
    When Send request get single user
    Then API should return response 404 Not Found

  @Tugas @NegativeCase
  Scenario: Get single User not found
    Given Get list user with page 23
    When Send request get single user
    Then API should return response 404 Not Found

  @Tugas @PositiveCase
  Scenario: Get single Resource with valid parameter
    Given get single resource with page 2
    When Send request get single resource
    Then API should return response 200 OK
    Then Response body should contain name "sand dollar", color "#DECDBE", and pantone_value "13-1106"

  @Tugas @PositiveCase
  Scenario Outline: Get single Resource with valid parameter
    Given get single resource with page 2
    When Send request get single resource
    Then API should return response 200 OK
    Then Response body should contain name "<name>", color "<color>", and pantone_value "<pantone_value>"
  Examples:
    |name|color|pantone_value|
    |sand dollar|#DECDBE|13-1106|

  @Tugas @NegativeCase
  Scenario: Get single Resource not found
    Given get single resource with page 23
    When Send request get single resource
    Then API should return response 404 Not Found

  @Tugas @NegativeCase
  Scenario: Get single Resource with invalid parameter
    Given get single resource with page "#@!"
    When Send request get single user
    Then API should return response 404 Not Found

  @Tugas @PositiveCase
  Scenario: Register-successful
    Given register new user with valid json file
    When When Send request post register user
    Then API should return response 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"

  @Tugas @NegativeCase
  Scenario: Register-Unsuccessful
    Given register new user with invalid json file
    When When Send request post register user
    Then API should return response 400 BAD REQUEST
    And Response body should contain error message "Missing password"

  @Tugas @PositiveCase
  Scenario: Login - Successful
    Given login user with valid json file
    When Send request post login user
    Then API should return response 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"

  @Tugas @NegativeCase
  Scenario: Login - Unsuccessful
    Given login user with invalid json file
    When Send request post login user
    Then API should return response 400 BAD REQUEST
    And Response body should contain error message "Missing password"

  @Tugas @PositiveCase
  Scenario Outline: GET single list user with valid parameter (delay)
    Given Get list user with delay <parameter>
    When Send request get single user with delay
    Then API should return response status code <status code>
    And take time <parameter>
  Examples:
    |parameter|status code|
    |3        |200        |
    |30       |503        |
    |32       |200        |

  @Latihan @PositiveCase
  Scenario Outline: Put Update user
    Given Put update user with id <id> and with valid json file
    When Send request put update user
    Then API should return response 200 OK
    And Response body should contain name "Luqman Hanung Asidiq" and job "Quality Assurance Engineer"
  Examples:
    |id|
    |1 |
    |2 |

  @Tugas @PositiveCase
  Scenario: Put Update user (without outline scenario)
    Given Put update user with id 1 and with valid json file
    When Send request put update user
    Then API should return response 200 OK
    And Response body should contain name "Luqman Hanung Asidiq" and job "Quality Assurance Engineer"

  @Tugas @PositiveCase
  Scenario: Patch Update user (without outline scenario)
    Given Patch update user with id 1 and with valid json file
    When Send request patch update user
    Then API should return response 200 OK
    And Response body should contain name "Justin Bieber" and job "Quality Assurance Engineer"

  @Latihan @PositiveCase
  Scenario Outline: Delete user With valid id
    Given Delete user with id <id>
    When Send request delete user
    Then API should return response 204 NO CONTENT
  Examples:
    |id|
    |2 |
    |3 |

  @Tugas @NegativeCase
  Scenario Outline: Delete user With invalid id
    Given Delete user with id <id>
    When Send request delete user
    Then API should return response 404 Not Found
    Examples:
      |id|
      |400 |
      |EWQ# |
      |     |


