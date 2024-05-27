package steps;

import com.crowdar.core.PageSteps;
import services.GenericService;
import services.TimeEntryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimeEntrySteps extends PageSteps {
    @And("the user logs in$")
    public void theUserLogsIn() {
        GenericService.fullLogin();
    }

    @And("the user taps on Add Manually button$")
    public void theUserTapsOnAddButton() {
        TimeEntryService.addNewTimeEntry();
    }

    @And("the user inputs (.*) as the desired duration$")
    public void theUserInputsDurationAsTheDesiredDuration(String duration) {
        TimeEntryService.inputEntryDuration(duration);
    }

    @And("the user inputs Time Entry (.*)$")
    public void theUserInputsTimeEntryDescription(String description) {
        TimeEntryService.enterTimEntryDesc(description);
    }

    @When("the user taps on Save button$")
    public void theUserTapsOnSaveButton() {
        TimeEntryService.tapSaveBtn();
    }

    @Then("the user can see the new Time entry listed$")
    public void theUserCanSeeTheNewTimeEntryListed() {
        TimeEntryService.verifyTimeEntryCreated();
    }


}
