Feature: Login
  @login
  Scenario: login with valid credentials
    Given user is on homepage
    When user navigates to login
    And enter valid username and password
    Then the user should be able to login successfully

  @login2
  Scenario Outline: login with invalid credentials
    Given user is on homepage
    When user navigates to login
    When the user enters "<username>" and "<password>"
    Then the invalid login sign should be seen on the page

    Examples:
      |   username                |   password      |
      |   abc@gmail.com           |   Nurel234      |
      |   nurelifkfl@gmail.com    |   123456        |
      |   esr@gmail.com           |   asfl236       |
