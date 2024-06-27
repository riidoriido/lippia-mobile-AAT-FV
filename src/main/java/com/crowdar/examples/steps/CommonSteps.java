package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.MiscConstants;
import com.crowdar.examples.services.GenericService;
import io.cucumber.java.en.*;

public class CommonSteps extends PageSteps {

    @Given("The app is loaded correctly")
    @Then("Login page is displayed")
    public void isLoginPageVisible() {
        GenericService.verifyAppLoaded();
    }
    @And("the user taps on Menu button")
    public void theUserTapsOnMenuButton() {
        GenericService.deployMenu();
    }

    @And("the user selects workspace {string}")
    public static void changeWorkspace(String workspaceName) {
        GenericService.checkIfWorkspaceIsCorrect(workspaceName);
    }
    @And("the user taps on {string} button")
    public void theUserTapsOnButton(String buttonTxt) {
        GenericService.tapOnButtonByText(buttonTxt);
    }
}
