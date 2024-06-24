package com.crowdar.examples.steps;

import com.crowdar.examples.services.ApiHelperService;
import com.crowdar.examples.services.TimeEntryService;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.GenericService;
import io.cucumber.java.en.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

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
    @And("the user taps on Calendar button")
    public void theUserTapsOnCalendarButton() {
        TimeEntryService.openCalendar();
    }

    @And("the user taps on Previous Month button")
    public void theUserTapsOnPreviousMonthButton() {
        TimeEntryService.switchMonthCalendar();
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

    @AfterTest
    public static void cleanupAfterTest() {
        ApiHelperService.cleanUpEntriesAfterTest();
    }

}
