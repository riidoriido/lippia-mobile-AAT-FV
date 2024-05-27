package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import org.openqa.selenium.By;
import org.testng.Assert;



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

}
