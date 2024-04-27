Feature: Login functionality

  Scenario Outline: User logs in with valid credentials
    Given the user is on the login page
    When they enter "<username>" and "<password>"
    And they click the login button
    Then they should be redirected to the dashboard

  Examples:
    | username | password |
    | student    | Password123    |
    | incorrectUser    | Password123    |
    | user3student    | incorrectPassword    |
