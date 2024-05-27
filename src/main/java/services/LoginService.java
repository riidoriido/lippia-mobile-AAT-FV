package services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.MobileActionManager;
import constants.LoginConstants;
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

        String keyId = identifier;
        Map<String, String> inputsLocator = Map.of(
                "username", LoginConstants.INPUT_EMAIL,
                "password", LoginConstants.INPUT_PASSWORD
        );

        if (!inputsLocator.containsKey(keyId)) {
            throw new IllegalArgumentException("Invalid identifier: " + identifier);
        }

        String credentials = getCredentials(keyId);
        MobileActionManager.setInput(inputsLocator.get(keyId), credentials);
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


    public static void main(String[] args) {

    }
}
