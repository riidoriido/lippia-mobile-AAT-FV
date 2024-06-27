@Regression
Feature: Clockify App Log In

  Background:
    Given The app is loaded correctly

  @Smoke @LogInSuccess
  Scenario: Successful log in to Clockify App
    When the user taps on Log in Manually
    And the user inputs credential username
    And the user inputs credential password
    And the user taps on log in button
    Then the user is logged in and can see the dashboard

    @Logout
  Scenario: Successful log out from Clockify App
    When the user logs in
    And the user taps on Menu button
    And the user taps on Log out button
    And the user taps on Confirm button
    Then the user is logged out and can see the log in screen

