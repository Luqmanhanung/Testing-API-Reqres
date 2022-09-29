Feature: Request to API Reqres.in
  @Tugas @PositiveCase
  Scenario Outline: GET list user with valid parameter (page)
    Given Get list user with page <Parameter>
    When Send request get list user
    Then API should return response 200 OK
    And Response body should contain id <Id>, firstname "<Firstname>", lastname "<Lastname>" and email "<Email>"
    And Response body page should be <Parameter>
    And Get list user assert json validation
  Examples:
      |Id|Parameter|Firstname|Lastname|Email|
      |3|1        |Emma     |Wong   |emma.wong@reqres.in|
      |9|2        |Tobias  |Funke  |tobias.funke@reqres.in|

  @Latihan @PositiveCase
  Scenario: GET list user with valid parameter (page) (without outline scenario)
    Given Get list user with page 1
    When Send request get list user
    Then API should return response 200 OK
    And Response body should contain id 3, firstname "Emma", lastname "Wong" and email "emma.wong@reqres.in"
    And Response body page should be 1
    And Get list user assert json validation

  @Tugas @NegativeCase
  Scenario: GET list user with invalid parameter (page)
    Given Get list user with page "ad"
    When Send request get list user
    Then API should return response 404 Not Found

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
      |300 |
      |#!a |
      |    |

  @Tugas @NegativeCase
  Scenario: GET list user not found
    Given Get list user with page 23
    When Send request get list user
    Then API should return response 404 Not Found

  @Tugas @NegativeCase
  Scenario: POST create user with invalid credential (without outline scenario)
    Given Post create new user with invalid json file
    When Send request post create user
    Then API should return response 400 BAD REQUEST

  @Latihan @PositiveCase
  Scenario Outline: POST create user valid credential
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "<name>" and job "<job>"
    And Post create user assert json validation
  Examples:
    |name          |job                 |
    |Luqman Hanung |Software QA Engineer|

  @Tugas @PositiveCase
  Scenario: GET list Resource with valid parameter
    Given get list resource with valid page 2
    When Send request get list resources
    Then API should return response 200 OK
    Then Response body should contain id 7, name "sand dollar", year 2006, color "#DECDBE", and pantone_value "13-1106"
    And Get list resource assert json validation

  @Tugas @PositiveCase
  Scenario Outline: GET list Resource with valid parameter
    Given get list resource with valid page 2
    When Send request get list resources
    Then API should return response 200 OK
    Then Response body should contain name "<name>", color "<color>", and pantone_value "<pantone_value>"
    And Get list resource assert json validation
  Examples:
    |name|color|pantone_value|
    |sand dollar|#DECDBE|13-1106|

  @Tugas @NegativeCase
  Scenario: GET list Resource not found
    Given get list resource with valid page 23
    When Send request get list resources
    Then API should return response 404 Not Found

  @Tugas @NegativeCase
  Scenario: GET list Resource with invalid parameter
    Given get list resource with invalid page "#@!"
    When Send request get list resources
    Then API should return response 404 Not Found

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
      |300 |
      |@#$ |
      |    |

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

  @Tugas @PositiveCase
  Scenario Outline: GET single list user with valid parameter (delay)
    Given Get list user with delay <parameter>
    When Send request get single user with delay
    Then API should return response status code <status code>
  Examples:
    |parameter|status code|
    |3        |200        |
    |30       |503        |
    |32       |200        |

  @Tugas @NegativeCase
  Scenario Outline: PUT Update user with invalid id
    Given Put update user with invalid id "<id>" and with valid json file
    When Send request put update user
    Then API should return response 404 Not Found
  Examples:
    |id|
    |@! |
    |sd |
    |   |

  @Latihan @PositiveCase
  Scenario: PUT Update user (without outline scenario)
    Given Put update user with id 1 and with valid json file
    When Send request put update user
    Then API should return response 200 OK
    And Response body should contain name "Luqman Hanung Asidiq" and job "Quality Assurance Engineer"
    And Put update user assert json validation

  @Tugas @NegativeCase
    Scenario: PUT update user without valid json file
    Given Put update user with id 1 and without valid json file
    When Send request put update user
    Then API should return response 400 BAD REQUEST

  @Tugas @NegativeCase
  Scenario: PUT update user with invalid json file
    Given Put update user with id 1 and with invalid json file
    When Send request put update user
    Then API should return response 400 BAD REQUEST

  @Tugas @PositiveCase
  Scenario: PATCH Update user (without outline scenario)
    Given Patch update user with id 1 and with valid json file
    When Send request patch update user
    Then API should return response 200 OK
    And Patch Response body should contain name "Justin Bieber"

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
    Then API should return response 404 Not Found
    Examples:
      |id|
      |400 |
      |EWQ# |
      |     |


