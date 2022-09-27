Feature: Request to API Reqres.in
  Scenario Outline: GET single list user with valid parameter
    Given Get list user with page <Parameter>
    When Send request get single user
    Then API should return response 200 OK
    And Response body should contain id <Id>, firstname "<Firstname>", lastname "<Lastname>" and email "<Email>"
    And Response body page should be <Parameter>

  Examples:
      |Id|Parameter|Firstname|Lastname|Email|
      |3|1        |Emma     |Wong   |emma.wong@reqres.in|
      |9|2        |Tobias  |Funke  |tobias.funke@reqres.in|

  @latihan
  Scenario: GET single list user with valid parameter (without outline scenario)
    Given Get list user with page 1
    When Send request get single user
    Then API should return response 200 OK
    And Response body should contain id 3, firstname "Emma", lastname "Wong" and email "emma.wong@reqres.in"
    And Response body page should be 1

  @latihan
  Scenario: POST create user with valid credential (without outline scenario)
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "Luqman Hanung" and job "Software QA Engineer"

  Scenario Outline: POST create user valid credential
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "<name>" and job "<job>"
  Examples:
    |name          |job                 |
    |Luqman Hanung |Software QA Engineer|

  Scenario: GET single list user with invalid parameter
    Given Get list user with page "ad"
    When Send request
    Then API should return response 404 Not Found

  Scenario: Get single Resource with valid parameter
    Given get single resource with page 2
    When Send request get single resource
    Then API should return response 200 OK
    Then Response body should contain name "sand dollar", color "#DECDBE", and pantone_value "13-1106"

  Scenario Outline: Get single Resource with valid parameter
    Given get single resource with page 2
    When Send request get single resource
    Then API should return response 200 OK
    Then Response body should contain name "<name>", color "<color>", and pantone_value "<pantone_value>"
  Examples:
    |name|color|pantone_value|
    |sand dollar|#DECDBE|13-1106|