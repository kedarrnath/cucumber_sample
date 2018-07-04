Feature: Login into application

  Scenario: Verify user able to login into application with proper details
    Given A user is on login page
    When  Provide Username and Password
    Then User able to login successfully