package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.MiscConstants;
import com.crowdar.examples.constants.ProjectsConstants;
import org.testng.Assert;

public class MiscService {



    public static void selectDarkMode() {
        MobileActionManager.waitVisibility(MiscConstants.THEME_DARK_SELECT).click();
    }
    public static void verifyThemeUpdated(String expectedText){
        String actualText = MobileActionManager.waitVisibility(MiscConstants.SETTINGS_THEME_SUBTEXT).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    public static void tapNewProject() {
        MobileActionManager.waitClickable(ProjectsConstants.PROJECTS_NEW_BUTTON).click();
    }

    public static void inputProjectName(String projectName) {
        MobileActionManager.setInput(ProjectsConstants.PROJECTS_PROJECT_NAME_INPUT,projectName);
    }

    public static void switchBillable() {
        MobileActionManager.click(ProjectsConstants.PROJECTS_BILLABLE_SWITCH);
    }

    public static void selectColorPicker(String hexValue) {
        MobileActionManager.waitClickable(ProjectsConstants.PROJECTS_COLOR_PICKER,hexValue).click();
    }

    public static void tapBackButton() {
        MobileActionManager.waitClickable(ProjectsConstants.PROJECTS_CANCEL_CREATION).click();
    }

    public static void verifyNoProjectAdded(String projectName){
        Assert.assertFalse(MobileActionManager.isPresent(ProjectsConstants.PROJECTS_LIST_PROJECT,projectName));
    }
}
