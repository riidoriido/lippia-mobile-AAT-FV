package steps;

import com.crowdar.core.PageSteps;
import services.GenericService;
import services.LoginService;
import io.cucumber.java.en.*;

public class LoginSteps extends PageSteps {

    @Given("The app is loaded correctly")
    @Then("Login page is displayed")
    public void isLoginPageVisible() {
        GenericService.verifyAppLoaded();
    }

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

}
