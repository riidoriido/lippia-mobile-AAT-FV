@Regression @TimeTracker
Feature: Clockify App Timetracker

  Background:
    Given The app is loaded correctly
    And the user logs in

  @AddTimeEntryQuick
  Scenario Outline: Successful Time Entry creation
    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user inputs Time Entry <description>
    When the user taps on Save button
    Then the user can see the new Time entry listed
    And changes are reverted by backend <-- preguntar si es necesario hacerlo en el scenario


    Examples:
      | duration | description          |
      | 8        | task_CleanAfterTest  |

  @Smoke @AddDetailedTimeEntry
  Scenario Outline: Successful Detailed Time Entry creation
    And the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user taps on Calendar button
    And the user taps on Previous Month button
    And the user taps on "<date>" button
    And the user taps on "OK" button
    And the user inputs Time Entry <description>
    And the user taps on "Project" button
    And the user taps on "mobileProject" button
    When the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | date | description |
      | 8        | 12   | taskTPFINAL |
