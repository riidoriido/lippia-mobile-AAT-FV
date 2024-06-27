package com.crowdar.examples.steps;

import com.crowdar.examples.services.LoginService;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;

public class LoginSteps extends PageSteps {


    @And("the user taps on Log in Manually")
    public void theUserTapsOnLogInManually() {
        LoginService.tapLoginManually();
    }

    @And("the user inputs credential (.*)$")
    public void userInputsCredential(String identifier) {
        LoginService.inputCredentials(identifier);
    }

    @When("the user taps on log in button$")
    public void theUserTapsOnButton() {
        LoginService.tapLogIn();
    }

    @Then("the user is logged in and can see the dashboard$")
    public void verifyUserIsLoggedIn() {
        LoginService.verifyLoggedin();
    }


    @And("the user taps on Log out button")
    public void theUserTapsOnLogOutButton() {
        LoginService.tapLogOut();
    }

    @When("the user taps on Confirm button")
    public void theUserTapsOnConfirmButton() {
        LoginService.tapConfirmButton();
    }

    @Then("the user is logged out and can see the log in screen")
    public void theUserIsLoggedOutAndCanSeeTheLogInScreen() {
        LoginService.verifyOnLoginScreen();
    }

}
