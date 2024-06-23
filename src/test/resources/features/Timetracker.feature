@Regression
Feature: Clockify App Timetracker

  Background:
    Given The app is loaded correctly
    And the user logs in

  @Smoke @AddTimeEntry
  Scenario Outline: Successful Time Entry creation

    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user taps on "OK" button
    And the user inputs Time Entry <description>
    When the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | description |
      | 8        | Test_task   |

  Scenario Outline: Successful Detailed Time Entry creation

    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration//////////
    And the user taps on Calendar button

    And the user inputs Time Entry <description>
    When the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | description |
      | 8        | Test_task   |
