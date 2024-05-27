package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.testng.Assert;

public class TimeEntryService {
    public static void addNewTimeEntry() {
        MobileActionManager.waitVisibility(LoginConstants.TIME_TRACKER_LIST);
        GenericService.clickByXpathGeneric(TimeEntryConstants.NEW_TIME_ENTRY);
        MobileActionManager.waitClickable(TimeEntryConstants.ADD_MANUAL_ENTRY).click();
    }

    public static void inputEntryDuration(String duration) {
        MobileActionManager.setInput(TimeEntryConstants.INPUT_HOURS,duration);
        MobileActionManager.click(TimeEntryConstants.SET_HOURS);
    }

    public static void enterTimEntryDesc(String description) {
        MobileActionManager.waitClickable(TimeEntryConstants.TIMEENTRY_DESCRIPTION_INPUT).click();
        MobileActionManager.setInput(TimeEntryConstants.TIMEENTRY_DESCRIPTION_INPUT,description);
    }

    public static void tapSaveBtn() {
        MobileActionManager.waitClickable(TimeEntryConstants.SAVE_BUTTON).click();
    }

    public static void verifyTimeEntryCreated() {
        Assert.assertTrue(MobileActionManager.waitVisibility(TimeEntryConstants.ADDED_TIME_ENTRY).isDisplayed());
    }

}
