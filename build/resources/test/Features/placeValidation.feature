Feature: Validating Place API's

  @AddPlace
  Scenario Outline: Verify if AddPlaceApi and GetPlaceApi functionality is working by adding place and checking if that's added
    Given Add Place Payload with "<name>"  "<language>" "<address>"
    When user calls "AddPlaceApi" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And verify place_Id created maps to "<name>" using "GetPlaceApi"
    Examples:
      | name | language | address            |
      | Tom  | English  | World cross center |
      | John | Spanish  | Toronto            |

  @DeletePlace
  Scenario: Verify if DeletePlaceApi functionality is working
    Given DeletePlace Payload
    When user calls "DeletePlaceApi" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
