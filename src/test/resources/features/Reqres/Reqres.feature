Feature: Request to API Reqres.in
  Scenario Outline: Get single list user
    Given Get list user with parameter "<parameter>"
    When Send request
    Then API should return response 200 OK
    And Response body should contain firstname "<firstname>" and lastname "<lastname>"
    #And Get list user assert json validation
    Examples:
    |parameter|firstname|lastname|
    |1        |Goerge   |Bluth   |
    |2        |Michael  |Lawson  |
