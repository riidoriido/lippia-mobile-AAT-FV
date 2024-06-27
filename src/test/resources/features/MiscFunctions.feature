@Regression @MiscFeatures
  Feature: Data entry and Settings

    Background:
      Given The app is loaded correctly
      And the user logs in
      And the user selects workspace "tpFinal_mobile"


    @SwitchTheme @Smoke
    Scenario: Switch app theme to dark mode
      When the user taps on Menu button
      And the user taps on "Settings" button
      And the user taps on "App theme" button
      And the user selects Dark option
      And the user taps on "OK" button
      Then the app should switch to "Dark" mode

    @CancelDataEntry @Smoke
    Scenario: Input data, then cancel operation
      When the user taps on Menu button
      And the user taps on "Projects" button
      And the user taps on New button
      And the user inputs project name "tpFinalProject"
      And the user makes the project non-billable
      And the user taps on "#FEBF32" on color picker
      And the user taps on Back button
      And the user taps on "Discard" button
      Then the user can see no projects have been added
