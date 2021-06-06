Feature: Login
  @login
  Scenario: login with valid credentials
    Given user is on homepage
    When user navigates to login
    And enter valid username and password
    Then the user should be able to login successfully