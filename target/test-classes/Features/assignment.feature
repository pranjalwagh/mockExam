Feature: Amazon user login and logout functionality

 Scenario: Login into the application with valid credentials
    Given I am on the Login page URL "https://www.amazon.in/"
    Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "8484002139"
    And I Click on Continue button
    And I enter password as "S@h1lwagh007"
    And click on login button
    Then I am logged in
    And I clear cart items if any
    Then I choose Electronics>Headphones and headphones list out
    Then I add first available headphone to cart
    Then I search "Macbook pro" and add second available item to cart
    Then I Select cart from home and remove the earlier added headphones
    Then I Reduce the Quantity of the macbook pro product to one and proceed to checkout
    And I Click on Sign out
    Then I got log out from the application and land on sign in page