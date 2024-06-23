package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.MiscService;
import io.cucumber.java.en.*;

public class MiscFunctionsSteps extends PageSteps {

    @And("the user taps on {string} button")
    public void theUserTapsOnButton(String buttonTxt) {
        MiscService.tapOnButtonByText(buttonTxt);
    }

    @And("the user selects Dark option")
    public void theUserSelectsDarkOption() {
        MiscService.selectDarkMode();
    }

    @Then("the app should switch to {string} mode")
    public void theAppShouldSwitchToMode(String expectedText) {
        MiscService.verifyThemeUpdated(expectedText);
    }
}
