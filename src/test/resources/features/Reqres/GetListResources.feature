Feature: Get list resources
  @Tugas @PositiveCase
  Scenario: GET list Resource with valid page
    Given get list resource with valid page 2
    When Send request get list resources
    Then API should return response 200 OK
    Then Response body should contain id 7, name "sand dollar", year 2006, color "#DECDBE", and pantone_value "13-1106"
    And Get list resource assert json validation

  @Tugas @PositiveCase
  Scenario Outline: GET list Resource with valid page
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
  Scenario: GET list Resource with invalid page
    Given get list resource with invalid page "#@!"
    When Send request get list resources
    Then API should return response 404 Not Found