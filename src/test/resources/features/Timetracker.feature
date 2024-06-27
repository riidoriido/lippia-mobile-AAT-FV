@Regression @Timetracker @CleanUpTimeEntry
Feature: Clockify App Timetracker

  Background:
    Given The app is loaded correctly
    And the user logs in
    And the user selects workspace "tpFinal_mobile"


  @AddTimeEntryQuick @Smoke @CleanupAfterCreation
  Scenario Outline: Successful Time Entry creation
    When the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user inputs Time Entry <description>
    And the user taps on Save button
    Then the user can see the new Time entry listed
    Examples:
      | duration | description          |
      | 8        | task_CleanAfterTest  |

  @AddDetailedTimeEntry @Smoke
  Scenario Outline: Successful Detailed Time Entry creation
    When the user taps on Add Manually button
    And the user inputs <duration> as the desired duration
    And the user taps on Calendar button
    And the user taps on Previous Month button
    And the user taps on "<date>" button
    And the user taps on "OK" button
    And the user inputs Time Entry <description>
    And the user taps on "Project" button
    And the user taps on "mobileProject" button
    And the user taps on Save button
    Then the user can see the new Time entry listed

    Examples:
      | duration | date | description |
      | 8        | 12   | taskTPFINAL |
