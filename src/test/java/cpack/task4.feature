Feature: Login Functionality

Scenario Outline: Login with valid credentials
    Given I open the login page
    When I enter username and password form gien sheet "<SheetName>" and rownumber <RowNumber>
    And I click the login button
    Then I should be logged in

Examples:
| SheetName | RowNumber |
| login    | 0|
| login    | 1|
| login    | 2|
