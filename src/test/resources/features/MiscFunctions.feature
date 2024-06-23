@Regression
  Feature: Data entry and Settings

    Background:
      Given The app is loaded correctly
      And the user logs in


    @SwitchTheme
    Scenario: Switch app theme to dark mode
      And the user taps on Menu button
      And the user taps on "Settings" button
      And the user taps on "App theme" button
      And the user selects Dark option
      When the user taps on "OK" button
      Then the app should switch to "Dark" mode