Feature: Automate the Sign In functionality

  Scenario: Sign In with Email ID and password
    Given Open web browser
     | browserName | Chrome |
    And Open amazon home page
    When The login credentials are as below
      | email    | abhishek.das0930@gmail.com |
      | password | RSpdkn7#                   |
    Then Sign into your amazon account with above mentioned credentials
