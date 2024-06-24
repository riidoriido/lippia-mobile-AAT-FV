package com.crowdar.examples.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.constants.MiscConstants;
import org.testng.Assert;

import java.util.Map;

public class LoginService {




    public static void tapLoginManually() {
        MobileActionManager.waitClickable(LoginConstants.LOGIN_MANUALLY).click();
    }

    public static void inputCredentials(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("Identifier null");
        }

        Map<String, String> inputsLocator = Map.of(
                "username", LoginConstants.INPUT_EMAIL,
                "password", LoginConstants.INPUT_PASSWORD
        );

        if (!inputsLocator.containsKey(identifier)) {
            throw new IllegalArgumentException("Invalid identifier: " + identifier);
        }

        String credentials = getCredentials(identifier);
        MobileActionManager.setInput(inputsLocator.get(identifier), credentials);
    }

    private static String getCredentials(String identifier) {
        String propertyKey = "clockify." + identifier;
        String propertyValue = PropertyManager.getProperty(propertyKey);

        if (propertyValue == null || propertyValue.isEmpty()) {
            throw new RuntimeException("Property null: " + propertyKey);
        }
        return propertyValue;
    }

    public static void tapLogIn() {
        MobileActionManager.click(LoginConstants.LOGIN_BUTTON);
    }



    public static void verifyLoggedin() {
        Assert.assertTrue(MobileActionManager.waitVisibility(LoginConstants.TIME_TRACKER_LIST).isDisplayed());
    }


    public static void deployMenu() {
        MobileActionManager.waitClickable(MiscConstants.DEPLOY_MENU).click();
    }

    public static void tapLogOut() {
        MobileActionManager.waitClickable(LoginConstants.LOGOUT_BUTTON).click();
    }

    public static void tapConfirmButton(){
        MobileActionManager.waitClickable(LoginConstants.LOGOUT_CONFIRMATION_BUTTON).click();
    }
    public static void verifyOnLoginScreen(){
        MobileActionManager.waitVisibility(LoginConstants.LOGIN_TITLE_TXT);
        Assert.assertTrue(MobileActionManager.isVisible(LoginConstants.LOGIN_TITLE_TXT));
    }
}
