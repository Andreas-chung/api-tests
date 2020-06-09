Feature: A user can log in

  Scenario: User can successfully log in
    Given a logged in user
    When the user attempts to retrieve their details
    Then the user receives an OK response
    And the user details includes the following:
      | id   | name          |
      | 1234 | andreas chung |