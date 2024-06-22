@Regression @ClockifyTP8
Feature: Clockify App Log In

  Background:
    Given The app is loaded correctly

  @Smoke @LogInSuccess
  Scenario: Successful log in to Clockify App
    And the user taps on Log in Manually
    And the user inputs credential username
    And the user inputs credential password
    When the user taps on log in button
    Then the user is logged in and can see the dashboard

    @Logout
  Scenario: Successful log out from Clockify App
    And the user logs in
    And the user taps on Menu button
    And the user taps on Log out button
    When the user taps on Confirm button
    Then the user is logged out and can see the log in screen

  @Smoke @AddTimeEntry
  Scenario Outline: Successful Time Entry creation
    And the user logs in
    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user inputs Time Entry <description>
    When the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | description |
      | 8        | Test_task   |

  Scenario Outline: Successful Detailed Time Entry creation
    And the user logs in
    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration//////////
    And the user inputs Time Entry <description>
    When the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | description |
      | 8        | Test_task   |

    Scenario: cancel data input

    Scenario: switch to dark mode