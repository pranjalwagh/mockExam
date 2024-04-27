Feature: Login Action
Scenario: Login with valid and invalid Credentials
Given User is on Home Page
When User navigate to Login Page
Then User enters "<username>" and "<password>"
And Keeping case as <Case>
Then User should get logged in
And Message displayed Login Successfully
Then User enters "<username>" and "<password>"
And Keeping case as <Case>
Then user will be asked to go back to login page
And Provide correct credentials

    Examples:
      | username        | password | Case   |
      | student  | Password123    | Valid  |
      | incorrectUser | Password123    | Invalid|
