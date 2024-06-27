package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.constants.MiscConstants;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;


public class GenericService {

    public static void verifyAppLoaded() {
        Assert.assertTrue(MobileActionManager.waitVisibility(LoginConstants.LOGIN_TITLE_TXT).isDisplayed(), "App was not loaded or element not found.");
    }

    public static void fullLogin() {
        MobileActionManager.click(LoginConstants.LOGIN_MANUALLY);
        LoginService.inputCredentials("username");
        LoginService.inputCredentials("password");
        LoginService.tapLogIn();
    }

    public static void clickByXpathGeneric(String locator) {
        DriverManager.getDriverInstance().findElement(By.xpath(locator)).click();
    }
    public static void deployMenu() {
        MobileActionManager.waitClickable(MiscConstants.DEPLOY_MENU).click();
    }

    public static void checkIfWorkspaceIsCorrect(String workspaceName) {
        MobileActionManager.waitClickable(MiscConstants.DEPLOY_MENU).click();
        String selectedWorkspace = MobileActionManager.getText(MiscConstants.MENU_WORKSPACE_SELECT);
        if (!selectedWorkspace.equals(workspaceName)) {
            MobileActionManager.click(MiscConstants.MENU_WORKSPACE_SELECT);
            MobileActionManager.click(MiscConstants.MISC_BUTTON_LOCATOR,workspaceName);
            MobileActionManager.click(MiscConstants.MENU_WORKSPACE_SELECT);
        }
        MobileActionManager.waitClickable(MiscConstants.MENU_TIMETRACKER_BUTTON).click();
        MobileActionManager.waitInvisibility(MiscConstants.MENU_TIMETRACKER_BUTTON);
    }

    public static void tapOnButtonByText(String buttonTxt) {
        MobileActionManager.waitClickable(MiscConstants.MISC_BUTTON_LOCATOR,buttonTxt).click();
    }

    public static String parseListToString(List<String> list) {
        return String.join(",", list);
    }

}
