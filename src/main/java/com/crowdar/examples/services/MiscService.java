package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.MiscConstants;
import org.testng.Assert;

public class MiscService {

    public static void tapOnButtonByText(String buttonTxt) {
        MobileActionManager.waitClickable(MiscConstants.MISC_BUTTON_LOCATOR,buttonTxt).click();
    }

    public static void selectDarkMode() {
        MobileActionManager.waitVisibility(MiscConstants.THEME_DARK_SELECT).click();
    }
    public static void verifyThemeUpdated(String expectedText){
        String actualText = MobileActionManager.waitVisibility(MiscConstants.SETTINGS_THEME_SUBTEXT).getText();
        Assert.assertEquals(expectedText, actualText);
    }
}
