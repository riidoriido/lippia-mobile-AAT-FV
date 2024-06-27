package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.MiscService;
import io.cucumber.java.en.*;

public class MiscFunctionsSteps extends PageSteps {



    @And("the user selects Dark option")
    public void theUserSelectsDarkOption() {
        MiscService.selectDarkMode();
    }

    @Then("the app should switch to {string} mode")
    public void theAppShouldSwitchToMode(String expectedText) {
        MiscService.verifyThemeUpdated(expectedText);
    }

    @And("the user taps on New button")
    public void theUserTapsOnNewButton() {
        MiscService.tapNewProject();
    }

    @And("the user inputs project name {string}")
    public void theUserInputsProjectName(String projectName) {
    MiscService.inputProjectName(projectName);
    }

    @And("the user makes the project non-billable")
    public void theUserMakesTheProjectNonBillable() {
        MiscService.switchBillable();
    }

    @And("the user taps on {string} on color picker")
    public void theUserTapsOnOnColorPicker(String hexValue) {
        MiscService.selectColorPicker(hexValue);
    }
    @When("the user taps on Back button")
    public void theUserTapsOnBackButton() {
        MiscService.tapBackButton();
    }
    @Then("the user can see no projects have been added")
    public void theUserCanSeeNoProjectsHaveBeenAdded() {
        MiscService.verifyNoProjectAdded("tpFinalProject");
    }


}
