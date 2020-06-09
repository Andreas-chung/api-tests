Feature: A user can log in


  Scenario: User can successfully log in
    When the following user attempts to login:
      | username | password    |
      | andreas  | password123 |
    Then the user receives an OK response

  Scenario: User can successfully login with data
    When the following user attempts to login:
      | username | password |
      | test    | pass     |
    Then the user receives an Unauthorised response

