Feature: Purchasing an item

  Background: user has already log in
    Given user is on homepage
    When user navigates to login
    And enter valid username and password
    Then the user should be able to login successfully

@purchase
    Scenario: user should be able to add item to the basket
      Given the user navigates to "Our Products" "Nutritional Supplements" "Lifeplus Recommends"
      And the user stores information of item in a txt file
      When user adds the item to the basket
      Then user should be able to see in the basket
      When user deletes item in the basket
      Then basket should be empty

